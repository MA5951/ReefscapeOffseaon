
package frc.robot.Subsystem.Elevator;

import com.MAutils.Components.Motor;
import com.MAutils.Components.Motor.MotorType;
import com.MAutils.RobotControl.State;
import com.MAutils.Subsystems.DeafultSubsystems.Constants.PositionSystemConstants;
import com.MAutils.Utils.GainConfig;
import com.ctre.phoenix6.signals.InvertedValue;

import frc.robot.PortMap;


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
    

    

    public static final State IDLE = new State("IDLE", Elevator.getInstance());
    public static final State INTAKE = new State("INTAKE", Elevator.getInstance());
    public static final State SCORING = new State("SCORING", Elevator.getInstance());
    public static final State BALL_INTAKE = new State("BALL_INTAKE", Elevator.getInstance());
    public static final State BALL_HOLDING = new State("BALL_HOLDING", Elevator.getInstance());
    public static final State BALL_PRESCORING = new State("BALL_PRESCORING", Elevator.getInstance());
    public static final State BALL_SCORING = new State("BALL_SCORING", Elevator.getInstance());
    public static final State CLOSE = new State("CLOSE", Elevator.getInstance());
    public static final State HOLD = new State("HOLD", Elevator.getInstance());


    //Lerner
    public static final double IDLE_HEIGHT = 0;
    public static final double INTAKE_HEIGHT = 0;
    public static final double BALL_LOW_INTAKE_HEIGHT = 0;
    public static final double BALL_HIGH_INTAKE_HEIGHT = 0;
    public static final double BALL_HOLDING_HEIGHT = 0;
    public static final double BALL_PRESCORING_HEIGHT = 0;
    public static final double BALL_SCORING_HEIGHT = 0;
    public static final double CLOSE_HEIGHT = 0;
    public static final double HOLDING_HEIGHT = 0;

    
    public static final double HEIGHT_L1 = 0;
    public static final double HEIGHT_L2 = 0;
    public static final double HEIGHT_L3 = 0;
    public static final double HEIGHT_L4 = 0;


}
