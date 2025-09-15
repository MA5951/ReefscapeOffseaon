
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
            ClimbConstants.IDLE);

    public static final RobotState INTAKE = new RobotState(
            "INTAKE",
            IntakeConstants.CORAL_INTAKE,
            ArmConstants.INTAKE,
            ElevatorConstants.INTAKE);

    public static final RobotState CORAL_HOLD = new RobotState(
            "CORAL_HOLD",
            IntakeConstants.CORAL_HOLD,
            ArmConstants.CORAL_HOLDING,
            ElevatorConstants.HOLD);

    public static final RobotState SCORING = new RobotState(
            "SCORING",
            IntakeConstants.CORAL_SCORING,
            ArmConstants.CORAL_SCORING,
            ElevatorConstants.SCORING);

    public static final RobotState EJECT = new RobotState(
            "EJECT",
            IntakeConstants.EJECT);

    public static final RobotState BALL_INTAKE = new RobotState(
            "BALL_INTAKE",
            IntakeConstants.BALL_INTAKE,
            ArmConstants.BALL_INTAKE,
            ElevatorConstants.BALL_INTAKE);

    public static final RobotState BALL_HOLDING = new RobotState(
            "BALL_HOLDING",
            IntakeConstants.BALL_HOLD,
            ArmConstants.BALL_HOLDING,
            ElevatorConstants.BALL_HOLDING);

    public static final RobotState BALL_PRESCORING = new RobotState(
            "BALL_PRESCORING",
            ElevatorConstants.BALL_PRESCORING);

    public static final RobotState BALL_SCORING = new RobotState(
            "BALL_SCORING",
            IntakeConstants.BALL_SCORING,
            ArmConstants.BALL_SCORING,
            ElevatorConstants.BALL_SCORING);

    public static final RobotState PRECLIMBING = new RobotState(
            "PRECLIMBING",
            IntakeConstants.IDLE,
            ArmConstants.IDLE,
            ElevatorConstants.CLOSE,
            ClimbConstants.OPEN);

    public static final RobotState CLIMBING = new RobotState(
            "PRECLIMBING",
            IntakeConstants.IDLE,
            ArmConstants.IDLE,
            ElevatorConstants.CLOSE,
            ClimbConstants.CLOSE);

    public static final RobotState SORTING = new RobotState(
            "SORTING",
            IntakeConstants.CORAL_SORTING);

}
