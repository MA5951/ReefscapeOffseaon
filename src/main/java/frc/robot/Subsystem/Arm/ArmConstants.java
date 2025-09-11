
package frc.robot.Subsystem.Arm;

import com.MAutils.Components.Motor;
import com.MAutils.Components.Motor.MotorType;
import com.MAutils.RobotControl.State;
import com.MAutils.Subsystems.DeafultSubsystems.Constants.PositionSystemConstants;
import com.MAutils.Utils.GainConfig;
import com.ctre.phoenix6.signals.InvertedValue;

import frc.robot.PortMap;

public class ArmConstants {

    private static final Motor Arm_Motor = new Motor(PortMap.ArmPorts.ARM_MOTOR, MotorType.KRAKEN,
            "Arm_Motor", InvertedValue.Clockwise_Positive);

    private static final GainConfig REEL_GAIN_CONFI = new GainConfig().withKP(1);

    public static final PositionSystemConstants ARM_CONSTANTS = PositionSystemConstants
            .newBuilder("Arm", REEL_GAIN_CONFI, Arm_Motor)
            .gear(0)
            .isBrake(true)
            .startPose(0)
            .range(0, 0)
            .tolerance(0)
            .build();

    public static final State IDLE = new State("IDLE", Arm.getInstance());
    public static final State INTAKE = new State("INTAKE  ", Arm.getInstance());
    public static final State CORAL_SCORING = new State("CORAL_SCORING ", Arm.getInstance());
    public static final State BALL_INTAKE = new State("BALL_INTAKE", Arm.getInstance());
    public static final State BALL_HOLDING = new State("BALL_HOLDING", Arm.getInstance());
    public static final State BALL_PRESCORING = new State("BALL_PRESCORING", Arm.getInstance());
    public static final State BALL_SCORING = new State("BALL_SCORING", Arm.getInstance());
    public static final State CORAL_HOLDING = new State("CORAL_HOLDING ", Arm.getInstance());
    public static final State BALL_SORTING = new State("BALL_SORTING ", Arm.getInstance());


    public static final double IDLE_ANGLE = 0;
    public static final double INTAKE_ANGLE = 0;
    public static final double CORAL_HOLDING_ANGLE = 0;
    public static final double CORAL_EJECT_ANGLE = 0;
    public static final double BALL_INTAKE_ANGLE = 0;
    public static final double BALL_HOLDING_ANGLE = 0;
    public static final double BALL_PRESCORING_ANGLE = 0;
    public static final double BALL_SCORING_ANGLE = 0;
    public static final double KP = 0;
    public static final double KI = 0;
    public static final double KD = 0;

    public static final double ANGLE_L1 = 0;
    public static final double ANGLE_L2 = 0;
    public static final double ANGLE_L3 = 0;
    public static final double ANGLE_L4 = 0;

}
