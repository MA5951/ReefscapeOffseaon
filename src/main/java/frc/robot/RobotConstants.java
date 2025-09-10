
package frc.robot;

import com.MAutils.RobotControl.RobotState;

import frc.robot.Subsystem.Arm.ArmConstants;
import frc.robot.Subsystem.Elevator.ElevatorConstants;
import frc.robot.Subsystem.Intake.IntakeConstants;

public class RobotConstants {

    public static final RobotState IDLE = new RobotState(
        "IDLE", 
        IntakeConstants.IDLE,
        ArmConstants.IDLE,
        ElevatorConstants.IDLE );
    
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
        "Eject",
        IntakeConstants.CORAL_EJECT);

    public static final RobotState BALL_INTAKE = new RobotState(
        "BALL_INTAKE ",
        IntakeConstants.BALL_FORWARD,
        ArmConstants.BALL_INTAKE,
        ElevatorConstants.BALL_INTAKE);

}
