
package frc.robot;

import com.MAutils.RobotControl.RobotState;
import com.MAutils.Utils.DriverStationUtil;

import edu.wpi.first.math.geometry.Ellipse2d;
import edu.wpi.first.math.geometry.Pose2d;
import edu.wpi.first.math.geometry.Rectangle2d;
import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.geometry.Translation2d;
import edu.wpi.first.wpilibj.DriverStation.Alliance;
import frc.robot.Subsystem.Arm.ArmConstants;
import frc.robot.Subsystem.Climb.ClimbConstants;
import frc.robot.Subsystem.Elevator.ElevatorConstants;
import frc.robot.Subsystem.Intake.IntakeConstants;

public class RobotConstants {

    public static final RobotState IDLE = new RobotState(
        "IDLE", 
        IntakeConstants.IDLE,
        ArmConstants.IDLE,
        ElevatorConstants.IDLE,
        ClimbConstants.IDLE );
    
    public static final RobotState INTAKE = new RobotState(
        "INTAKE",
        IntakeConstants.CORAL_FORWARD,
        ArmConstants.INTAKE,
        ElevatorConstants.INTAKE);

    public static final RobotState CORAL_HOLD = new RobotState(
        "CORAL_HOLD ",
        IntakeConstants.CORAL_HOLD,
        ArmConstants.CORAL_HOLDING,
        ElevatorConstants.HOLD);

    public static final RobotState PRESCORING = new RobotState("PRESCORING ",
        IntakeConstants.CORAL_HOLD,
        ArmConstants.CORAL_SCORING,
        ElevatorConstants.SCORING);

    public static final RobotState Eject = new RobotState(
        "EJECT",
        IntakeConstants.CORAL_EJECT);

    public static final RobotState BALL_INTAKE = new RobotState(
        "BALL_INTAKE ",
        IntakeConstants.BALL_FORWARD,
        ArmConstants.BALL_INTAKE,
        ElevatorConstants.BALL_INTAKE);

    public static final RobotState BALL_HOLDING  = new RobotState(
        "BALL_HOLDING ",
        IntakeConstants.BALL_HOLD,
        ArmConstants.BALL_HOLDING,
        ElevatorConstants.BALL_HOLDING);

    public static final RobotState BALL_SCORING = new RobotState(
        "BALL_SCORING ",
        IntakeConstants.BALL_BACKWARD,
        ArmConstants.BALL_SCORING,
        ElevatorConstants.BALL_SCORING);

    public static final RobotState PRECLIMBING = new RobotState("PRECLIMBING ",
        IntakeConstants.IDLE,
        ArmConstants.IDLE,
        ElevatorConstants.CLOSE,
        ClimbConstants.OPEN);

    public static final RobotState CLIMBING = new RobotState("PRECLIMBING ",
        IntakeConstants.IDLE,
        ArmConstants.IDLE,
        ElevatorConstants.CLOSE,
        ClimbConstants.CLOSE);

    public static final RobotState SORTING = new RobotState(
        "SORTING", 
        IntakeConstants.CORAL_SORTING);




    // FieldConstants
    public static final Translation2d FieldZeroCorner = new Translation2d(0, 0);
    public static final Translation2d FieldFarCorner = new Translation2d(17.548, 8.052);
    public static final Translation2d FieldMiddlePoint = new Translation2d(17.548 / 2, 8.052 / 2);
    public static final Rectangle2d FieldRectangle = new Rectangle2d(FieldZeroCorner, FieldFarCorner);
    public static final Ellipse2d BLUE_REEF_CIRCLE = new Ellipse2d(new Translation2d(3.6576 + 0.831596, 4.0259), 0.9);
    public static final Ellipse2d RED_REEF_CIRCLE = new Ellipse2d(new Translation2d(12.227305999999999 + 0.831596, 4.0259), 0.9);
    public static final Translation2d ReefCenterBlue = new Translation2d(4.45, 4);//TODO
    public static final Translation2d ReefCenterRed = new Translation2d(4.45, 13.2);//TODO
    public static final Translation2d ReefCenter = DriverStationUtil.getAlliance() == Alliance.Blue ? ReefCenterBlue
            : ReefCenterRed;

    //Reef
    public static final Pose2d Tag6Pose = new Pose2d(13.474446, 3.3063179999999996, Rotation2d.fromDegrees(120));
    public static final Pose2d Tag7Pose = new Pose2d(13.890498, 4.0259, Rotation2d.fromDegrees(180));
    public static final Pose2d Tag8Pose = new Pose2d(13.474446, 4.745482, Rotation2d.fromDegrees(-120));
    public static final Pose2d Tag9Pose = new Pose2d(12.643358, 4.745482, Rotation2d.fromDegrees(-60));
    public static final Pose2d Tag10Pose = new Pose2d(12.227305999999999, 4.0259, new Rotation2d(0));
    public static final Pose2d Tag11Pose = new Pose2d(12.643358, 3.3063179999999996, Rotation2d.fromDegrees(60));

    public static final Pose2d Tag17Pose = new Pose2d(4.073905999999999, 3.3063179999999996, Rotation2d.fromDegrees(60));
    public static final Pose2d Tag18Pose = new Pose2d(3.6576, 4.0259, new Rotation2d(0));
    public static final Pose2d Tag19Pose = new Pose2d(4.073905999999999, 4.745482, Rotation2d.fromDegrees(-60));
    public static final Pose2d Tag20Pose = new Pose2d(4.904739999999999, 4.745482, Rotation2d.fromDegrees(-120));
    public static final Pose2d Tag21Pose = new Pose2d(5.321046, 4.0259, Rotation2d.fromDegrees(180));
    public static final Pose2d Tag22Pose = new Pose2d(4.904739999999999, 3.3063179999999996, Rotation2d.fromDegrees(120));


    //Source
    public static final Pose2d Tag1Pose = new Pose2d(16.697198, 0.65532, Rotation2d.fromDegrees(-52));
    public static final Pose2d Tag2Pose = new Pose2d(16.697198, 7.3964799999999995, Rotation2d.fromDegrees(52));
    public static final Pose2d Tag12Pose = new Pose2d(0.851154, 0.65532, Rotation2d.fromDegrees(-127));
    public static final Pose2d Tag13Pose = new Pose2d(0.851154, 7.3964799999999995, Rotation2d.fromDegrees(127));

}
