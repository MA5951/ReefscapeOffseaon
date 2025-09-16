
package frc.robot.Subsystem.Swerve;

import com.MAutils.PoseEstimation.PoseEstimator;
import com.MAutils.Swerve.Controllers.AngleAdjustController;
import com.MAutils.Swerve.Controllers.FieldCentricDrive;
import com.MAutils.Swerve.Controllers.XYAdjustController;
import com.MAutils.Swerve.SwerveSystemConstants;
import com.MAutils.Swerve.SwerveSystemConstants.GearRatio;
import com.MAutils.Swerve.SwerveSystemConstants.WheelType;
import com.MAutils.Swerve.Utils.SwerveState;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.math.controller.ProfiledPIDController;
import edu.wpi.first.math.system.plant.DCMotor;
import edu.wpi.first.math.trajectory.TrapezoidProfile;
import frc.robot.PortMap;
import frc.robot.RobotContainer;
import frc.robot.RobotControl.SuperStructure;

public class SwerveConstants {

    // Swerve System Constants
    public static final SwerveSystemConstants SWERVE_CONSTANTS = new SwerveSystemConstants()
            .withPyshicalParameters(0.6, 0.6, 52, WheelType.BLACK_TREAD, 6.25)
            .withMotors(DCMotor.getKrakenX60(1), DCMotor.getFalcon500(1), PortMap.SwervePorts.SWERVE_MODULE_IDS,
                    PortMap.SwervePorts.PIGEON2)
            .withMaxVelocityMaxAcceleration(4.92, 10)
            .withOdometryUpdateRate(250)
            .withDriveCurrentLimit(80, true)// 45
            .withTurningCurrentLimit(30, true)
            .withGearRatio(GearRatio.L2);

    // PID Controllers
    public static final PIDController ANGLE_PID_CONTROLLER = new PIDController(0.1, 0, 0);

    public static final TrapezoidProfile.Constraints POSEXY_CONSTRAINTS = new TrapezoidProfile.Constraints(3, 3);
    public static final ProfiledPIDController POSEXY_PID_CONTROLLER = new ProfiledPIDController(1, 0, 0,
            POSEXY_CONSTRAINTS);
    public static final ProfiledPIDController RELATIV_PID_CONTROLLER = new ProfiledPIDController(1, 0, 0,
            POSEXY_CONSTRAINTS);

    // Swerve Drive Controllers
    public static final FieldCentricDrive FIELD_CENTRIC_DRIVE = new FieldCentricDrive(
            RobotContainer.getDriverController(), SWERVE_CONSTANTS);

    public static final AngleAdjustController ANGLE_ADJUST_CONTROLLER = new AngleAdjustController(SWERVE_CONSTANTS,
            ANGLE_PID_CONTROLLER).withSetPoint(() -> SuperStructure.getAngleAdjustSetPoint());

    public static final XYAdjustController XY_ADJUST_CONTROLLER = new XYAdjustController(SWERVE_CONSTANTS,
            POSEXY_PID_CONTROLLER,
            POSEXY_PID_CONTROLLER, () -> PoseEstimator.getCurrentPose().getX(),
            () -> PoseEstimator.getCurrentPose().getY());

    // Swerve States
    public static final SwerveState FIELD_CENTRIC = new SwerveState("Field Centric")
            .withOnStateEnter(() -> FIELD_CENTRIC_DRIVE.withSclers(1, 0.7))
            .withSpeeds(FIELD_CENTRIC_DRIVE);

    public static final SwerveState FIELD_CENTRIC_40 = new SwerveState("Field Centric 40 Precent")
            .withOnStateEnter(() -> FIELD_CENTRIC_DRIVE.withSclers(0.4, 0.7))
            .withSpeeds(FIELD_CENTRIC_DRIVE);

    public static final SwerveState FIELD_CENTRIC_40_ANGLE = new SwerveState("Field Centric 40 Angle")
            .withOnStateEnter(() -> FIELD_CENTRIC_DRIVE.withSclers(0.4, 0.7))
            .withXY(FIELD_CENTRIC_DRIVE).withOmega(ANGLE_ADJUST_CONTROLLER);

    public static final SwerveState POSE_ALIGN = new SwerveState("POSE_ALIGN")
            .withOnStateEnter(() -> XY_ADJUST_CONTROLLER.withFieldRelative(true))
            .withSpeeds(XY_ADJUST_CONTROLLER);
           // .withOmega(ANGLE_ADJUST_CONTROLLER);

    public static final SwerveState RELATIV_ALIGN = new SwerveState("RELATIVE_ALIGN")
            .withOnStateEnter(() -> XY_ADJUST_CONTROLLER.withFieldRelative(false))
            .withXY(XY_ADJUST_CONTROLLER)
            .withOmega(ANGLE_ADJUST_CONTROLLER);

    public static final SwerveState BACKWARDS = new SwerveState("BACKWARDS")
            .withXY(-1, 0)
            .withOmega(0);

}
