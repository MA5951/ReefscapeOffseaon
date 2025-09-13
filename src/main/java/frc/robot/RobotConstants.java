
package frc.robot;

import com.MAutils.RobotControl.RobotState;

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
            IntakeConstants.CORAL_FORWARD,
            ArmConstants.INTAKE,
            ElevatorConstants.INTAKE);

    public static final RobotState CORAL_HOLD = new RobotState(
            "CORAL_HOLD ",
            IntakeConstants.CORAL_HOLD,
            ArmConstants.CORAL_HOLDING,
            ElevatorConstants.CORAL_HOLD);

    public static final RobotState SCORING = new RobotState(
            "SCORING",
            IntakeConstants.CORAL_FORWARD,
            ArmConstants.CORAL_SCORING,
            ElevatorConstants.SCORING);

    public static final RobotState EJECT = new RobotState(
            "EJECT",
            IntakeConstants.CORAL_EJECT);

    public static final RobotState BALL_INTAKE = new RobotState(
            "BALL_INTAKE",
            IntakeConstants.BALL_FORWARD,
            ArmConstants.BALL_INTAKE,
            ElevatorConstants.BALL_INTAKE);

    public static final RobotState BALL_SORTING = new RobotState(
            "BALL_SORTING",
            IntakeConstants.BALL_SORTING,
            ArmConstants.BALL_SORTING,
            ElevatorConstants.BALL_SORTING);

    public static final RobotState BALL_HOLDING = new RobotState(
            "BALL_HOLDING",
            IntakeConstants.BALL_HOLD,
            ArmConstants.BALL_HOLDING,
            ElevatorConstants.BALL_HOLDING);

    public static final RobotState BALL_PRE_SCORING = new RobotState(
            "BALL_PRE_SCORING",
            ElevatorConstants.BALL_PRESCORING);

    public static final RobotState BALL_SCORING = new RobotState(
            "BALL_SCORING",
            IntakeConstants.BALL_BACKWARD,
            ArmConstants.BALL_SCORING,
            ElevatorConstants.BALL_SCORING);

    public static final RobotState PRECLIMBING = new RobotState("PRECLIMBING",
            IntakeConstants.IDLE,
            ArmConstants.IDLE,
            ElevatorConstants.IDLE,
            ClimbConstants.OPEN);

    public static final RobotState CLIMBING = new RobotState("PRECLIMBING",
            IntakeConstants.IDLE,
            ArmConstants.IDLE,
            ElevatorConstants.IDLE,
            ClimbConstants.CLOSE);

    public static final RobotState SORTING = new RobotState(
            "SORTING",
            IntakeConstants.CORAL_SORTING,
            ArmConstants.CORAL_SORTING,
            ElevatorConstants.CORAL_HOLD);

}
