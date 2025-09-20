
package frc.robot.Subsystem.Elevator;

import com.MAutils.Components.Motor;
import com.MAutils.Components.Motor.MotorType;
import com.MAutils.RobotControl.State;
import com.MAutils.Subsystems.DeafultSubsystems.Constants.PositionSystemConstants;
import com.MAutils.Utils.GainConfig;
import com.ctre.phoenix6.signals.InvertedValue;

import frc.robot.PortMap;
import frc.robot.RobotContainer;


public class ElevatorConstants {

    private static final Motor masterMotor = new Motor(PortMap.ElevatorPorts.MASTER_ELEVATOR_MOTOR,
     MotorType.KRAKEN, "masterMotor", InvertedValue.Clockwise_Positive);


    private static final Motor slaveMotor = new Motor(PortMap.ElevatorPorts.SLAVE_ELEVATOR_MOTOR,
     MotorType.KRAKEN, "slaveMotor", InvertedValue.Clockwise_Positive);

    private static final GainConfig REEL_GAIN_CONFI = new GainConfig().withKP(1);
    private static final GainConfig SIM_GAIN_CONFI = new GainConfig().withKP(5);

    public static final double SPROKET_PITCH_DIAMETER = 0.0444754;
    public static final double SPROKET_CIRCUMFERENCE = SPROKET_PITCH_DIAMETER * Math.PI;

    public static final PositionSystemConstants ELEVATOR_CONSTANTS = PositionSystemConstants
    .newBuilder("Elevator",REEL_GAIN_CONFI, masterMotor, slaveMotor)
    .simGains(SIM_GAIN_CONFI)
    .gear(82d / 12d)
    .isBrake(true)
    .startPose(0)
    .range(0, 1.5)
    .tolerance(0.02)
    .positionFactor(0.00116436)
    .motionMagic((14 / SPROKET_CIRCUMFERENCE )*1.7, (30 / SPROKET_CIRCUMFERENCE) * 2.3, 0)
    .build();
    

    

    public static final State IDLE = new State("IDLE", RobotContainer.elevator);
    public static final State INTAKE = new State("INTAKE", RobotContainer.elevator);
    public static final State SCORING = new State("SCORING", RobotContainer.elevator);
    public static final State BALL_INTAKE = new State("BALL_INTAKE", RobotContainer.elevator);
    public static final State BALL_HOLDING = new State("BALL_HOLDING", RobotContainer.elevator);
    public static final State BALL_PRESCORING = new State("BALL_PRESCORING", RobotContainer.elevator);
    public static final State BALL_SCORING = new State("BALL_SCORING", RobotContainer.elevator);
    public static final State CLOSE = new State("CLOSE", RobotContainer.elevator);
    public static final State HOLD = new State("HOLD", RobotContainer.elevator);


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
