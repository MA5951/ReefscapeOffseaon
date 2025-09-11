package frc.robot.Subsystem.Intake;

import com.MAutils.Subsystems.DeafultSubsystems.Systems.PowerControlledSystem;

import edu.wpi.first.wpilibj2.command.Command;

public class Intake extends PowerControlledSystem {

    private static Intake intake;
    
    private Intake() {
        super(IntakeConstants.INTAKE_CONSTANTS);
    }

    @Override
    public Command getSelfTest() {
       return null;
    }

    @Override
    public boolean CAN_MOVE() {
        return true;
    }
    public static boolean getRearSensor() {
        return false;
    }

    public static boolean getFrontSensor() {
        return false;
    }
public static boolean isCoral() {
        if (getFrontSensor() || getRearSensor()) {
            return true;
        } else {
            return false;
        }
    }
public static boolean getBallSensor() {
       if (BallSensor() < IntakeConstants.BALL_DISTANCE) {
           return true;
       } else {
           return false;
       }
    }
    
    public static boolean isGamePiece() {
        if (getBallSensor() || isCoral()){
            return true;
        } else {
            return false;
        }
    }
public static double BallSensor() {
        return 0;
    }

    public static final Intake getInstance() {
        if(intake == null) {
            intake = new Intake();
        }
        return intake;
    }
}
