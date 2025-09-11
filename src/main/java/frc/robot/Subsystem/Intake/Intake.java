package frc.robot.Subsystem.Intake;

import com.MAutils.Subsystems.DeafultSubsystems.Systems.PowerControlledSystem;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.RobotConstants;
import frc.robot.RobotContainer;

public class Intake extends PowerControlledSystem {

    private static Intake intake;
    
    private Intake() {
        super(IntakeConstants.INTAKE_CONSTANTS);
    }

    @Override
    public Command getSelfTest() {
       return null;
    }

    public boolean Intakecanmove(){
     return false;
    }

    public boolean Holdcanmove(){
      if(RobotContainer.getRobotState().getStateName() == RobotConstants.INTAKE.getStateName() ) {}

      return true;
    }

    @Override
    public boolean CAN_MOVE() {
        return true;
    }
    public boolean getRearSensor() {
        return false;
    }

    public boolean getFrontSensor() {
        return false;
    }
public boolean isCoral() {
        if (getFrontSensor() || getRearSensor()) {
            return true;
        } else {
            return false;
        }
    }
public boolean getBallSensor() {
       if (BallSensor() < IntakeConstants.BALL_DISTANCE) {
           return true;
       } else {
           return false;
       }
    }
    
    public boolean isGamePiece() {
        if (getBallSensor() || isCoral()){
            return true;
        } else {
            return false;
        }
    }
public double BallSensor() {
        return 0;
    }

    public static final Intake getInstance() {
        if(intake == null) {
            intake = new Intake();
        }
        return intake;
    }

    

    
}
