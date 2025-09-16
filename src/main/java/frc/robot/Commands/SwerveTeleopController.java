
package frc.robot.Commands;

import com.MAutils.Swerve.SwerveSystemController;

import frc.robot.RobotContainer;
import frc.robot.Subsystem.Swerve.SwerveConstants;

public class SwerveTeleopController extends SwerveSystemController{

    public SwerveTeleopController() {
        super(RobotContainer.swerve, SwerveConstants.SWERVE_CONSTANTS, RobotContainer.getDriverController());
    }

    public void ConfigControllers() {
        SwerveConstants.ANGLE_PID_CONTROLLER.enableContinuousInput(-180, 180);
    }

    public void SetSwerveState() {
        setState(SwerveConstants.POSE_ALIGN);
    }
}