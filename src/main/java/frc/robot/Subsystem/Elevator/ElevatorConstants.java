
package frc.robot.Subsystem.Elevator;

import com.MAutils.Components.Motor;
import com.MAutils.Components.Motor.MotorType;
import com.MAutils.RobotControl.State;
import com.MAutils.Subsystems.DeafultSubsystems.Constants.PositionSystemConstants;
import com.MAutils.Utils.GainConfig;
import com.ctre.phoenix6.signals.InvertedValue;

import frc.robot.PortMap;
import frc.robot.Subsystem.Climb.Climb;

public class ElevatorConstants {

    private static final Motor masterMotor = new Motor(PortMap.ElevatorPorts.MASTER_ELEVATOR_MOTOR,
     MotorType.KRAKEN, "masterMotor", InvertedValue.Clockwise_Positive);


    private static final Motor slaveMotor = new Motor(PortMap.ElevatorPorts.SLAVE_ELEVATOR_MOTOR,
     MotorType.KRAKEN, "slaveMotor", InvertedValue.Clockwise_Positive);

    private static final GainConfig REEL_GAIN_CONFI = new GainConfig().withKP(1);

    public static final PositionSystemConstants ELEVATOR_CONSTANTS = PositionSystemConstants
    .newBuilder("Elevator",REEL_GAIN_CONFI, masterMotor, slaveMotor)
    .gear(0)
    .isBrake(true)
    .startPose(0)
    .range(0, 0)
    .tolerance(0)
    .build();
    // TODO

    public static final State IDLE = new State("IDLE", Climb.getInstance());
    public static final State INTAKE = new State("INTAKE", Climb.getInstance());
    public static final State SCORING = new State("SCORING ", Climb.getInstance());
    public static final State BALL_INTAKE = new State("BALL_INTAKE ", Climb.getInstance());
    public static final State BALL_HOLDING = new State("BALL_HOLDING ", Climb.getInstance());
    public static final State BALL_SCORING = new State("BALL_SCORING  ", Climb.getInstance());
    public static final State CLOSE_HIGHT = new State("CLOSE_HIGHT  ", Climb.getInstance());
    public static final State HOLD = new State("HOLD ", Climb.getInstance());

    public static final double IDLE_HEIGHT = 0;
    public static final double INTAKE_HEIGHT = 0;
    public static final double L1_HEIGHT = 0;
    public static final double L2_HEIGHT = 0;
    public static final double L3_HEIGHT = 0;
    public static final double L4_HEIGHT = 0;
    public static final double BALL_LOW_INTAKE_HEIGHT = 0;
    public static final double BALL_HIGH_INTAKE_HEIGHT = 0;
    public static final double BALL_HOLDING_HEIGHT = 0;
    public static final double BALL_SCORING_HEIGHT = 0;
    public static final double CLOSE_HEIGHT = 0;
    public static final double HOLDING_HEIGHT = 0;
}
