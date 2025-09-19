
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
                        .builder("Intake", intakeMotor)
                        .gear(3)
                        .isBrake(true)
                        .build(PowerSystemConstants::new);

        public static final State IDLE = new State("IDLE", Intake.getInstance());
        public static final State CORAL_INTAKE = new State("CORAL_INTAKE", Intake.getInstance());
        public static final State CORAL_SCORING = new State("CORAL_SCORING", Intake.getInstance());
        public static final State EJECT = new State("EJECT", Intake.getInstance());
        public static final State BALL_INTAKE = new State("BALL_INTAKE", Intake.getInstance());
        public static final State BALL_SCORING = new State("BALL_SCORING", Intake.getInstance());
        public static final State CORAL_HOLD = new State("CORAL_HOLD", Intake.getInstance());
        public static final State BALL_HOLD = new State("BALL_HOLD", Intake.getInstance());
        public static final State CORAL_SORTING = new State("CORAL_SORTING", Intake.getInstance());

        // Lerner
        public static final double IDLE_VOLTS = 0;
        public static final double CORAL_INTAKE_VOLTS = -4;
        public static final double CORAL_SORTING_FORWARD_VOLTS = 3;
        public static final double CORAL_SORTING_BACKWARD_VOLTS = -3;
        public static final double CORAL_HOLD_VOLTS = 0;
        public static final double CORAL_FORWARD_VOLTS = 0;
        public static final double CORAL_EJECT_VOLTS = 5;
        public static final double BALL_INTAKE_VOLTS = -3;
        public static final double BALL_HOLD_FORWARD_VOLTS = 1;
        public static final double BALL_HOLD_BACKWARD_VOLTS = -1;
        public static final double BALL_BEFORE_SCORING_VOLTS = -2;
        public static final double BALL_SCORING_VOLTS = 7;
        public static final double BALL_EJECT_VOLTS = 6;

        public static final double EJECT_SPEED_L1 = 5;
        public static final double EJECT_SPEED_L234 = -5;

        public static final double SORTING_NUM = 5;

        public static final double BALL_SCORING_DISTANCE = 0;
        public static final double BALL_INTAKE_DISTANCE = 0;
        public static final double BALL_HOLDING_MAX_DISTANCE = 0;
        public static final double BALL_HOLDING_MIN_DISTANCE = 0;

     

}
