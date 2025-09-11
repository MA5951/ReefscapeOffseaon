package frc.robot.Subsystem.Climb;

import com.MAutils.Components.Motor;
import com.MAutils.Components.Motor.MotorType;
import com.MAutils.RobotControl.State;
import com.MAutils.Subsystems.DeafultSubsystems.Constants.PositionSystemConstants;
import com.MAutils.Utils.GainConfig;
import com.ctre.phoenix6.signals.InvertedValue;

import frc.robot.PortMap;

public class ClimbConstants {

    private static final Motor masterMotor = new Motor(PortMap.ClimbPorts.MASTER_CLIMB_MOTOR, MotorType.KRAKEN,
     "masterMotor", InvertedValue.Clockwise_Positive);

    private static final Motor slaveMotor = new Motor(PortMap.ClimbPorts.SLAVE_CLIMB_MOTOR, MotorType.KRAKEN,
     "slaveMotor", InvertedValue.Clockwise_Positive);

    private static final GainConfig REEL_GAIN_CONFI = new GainConfig().withKP(1);

    public static final PositionSystemConstants CLIMB_CONSTANTS = PositionSystemConstants
    .newBuilder("Climb",REEL_GAIN_CONFI, masterMotor, slaveMotor)
    .gear(0)
    .isBrake(true)
    .startPose(0)
    .range(0, 0)
    .tolerance(0)
    .build();



    public static final State IDLE = new State("IDLE", Climb.getInstance());
    public static final State OPEN = new State("OPEN  ", Climb.getInstance());   
    public static final State CLOSE = new State( "CLOSE", Climb.getInstance());
    public static final State RSET = new State("RESET ", Climb.getInstance());

    public static final double IDLE_ANGLE = 0;
    public static final double OPEN_ANGLE = 0;
    public static final double CLOSE_ANGLE = 0;
    public static final double RESER_ANGLE = 0;

}
