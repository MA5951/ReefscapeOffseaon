
package frc.robot.Subsystem.Intake;

import com.MAutils.Components.Motor;
import com.MAutils.Components.Motor.MotorType;
import com.MAutils.RobotControl.State;
import com.MAutils.Subsystems.DeafultSubsystems.Constants.PowerSystemConstants;
import com.ctre.phoenix6.signals.InvertedValue;

import frc.robot.PortMap;

public class IntakeConstants {

    private static final Motor intakeMotor = new Motor(PortMap.IntakePorts.INTAKE_MOTOR, MotorType.KRAKEN,
     "intakeMotor", InvertedValue.Clockwise_Positive);

    public static final PowerSystemConstants INTAKE_CONSTANTS = PowerSystemConstants
    .builder("INTAKE_CONSTANTS", intakeMotor)
    .gear(0)
    .isBrake(true)
    .build(PowerSystemConstants::new);

    public static final State IDLE = new State("IDLE", Intake.getInstance());
    public static final State CORAL_FORWARD = new State("CORAL_FORWARD", Intake.getInstance());
    public static final State CORAL_EJECT  = new State("CORAL_EJECT ", Intake.getInstance());
    public static final State BALL_FORWARD  = new State("BALL_FORWARD ", Intake.getInstance());
    public static final State BALL_BACKWARD  = new State("BALL_BACKWARD ", Intake.getInstance());
    public static final State CORAL_HOLD   = new State("CORAL_HOLD  ", Intake.getInstance());
    public static final State BALL_HOLD   = new State("BALL_HOLD  ", Intake.getInstance());
    public static final State CORAL_SORTING  = new State("CORAL_SORTING ", Intake.getInstance());
    public static final State BALL_SORTING  = new State("BALL_SORTING ", Intake.getInstance());

    public static final double IDLE_VOLTS = 0;
    public static final double CORAL_FORWARD_VOLTS = 0;
    public static final double CORAL_EJECT_VOLTS = 0;
    public static final double BALL_FORWARD_VOLTS = 0;
    public static final double BALL_BACKWARD_VOLTS = 0;
    public static final double CORAL_HOLD_VOLTS = 0;
    public static final double BALL_HOLD_VOLTS = 0;
    public static final double CORAL_SORTING_FORWARD_VOLTS = 0;
    public static final double CORAL_SORTING_BACKWARD_VOLTS = 0;
    public static final double SORTING_NUM = 0;
    public static final double BALL_SORTING_FORWARD_VOLTS = 0;
    public static final double BALL_SORTING_BACKWARD_VOLTS = 0;
    public static final double BALL_SORTING_NUM = 0;
    public static final double BALL_DISTANCE = 0;

    public static final double EJECT_SPEED_L1 = 0;
    public static final double EJECT_SPEED_L234 = 0;


}
