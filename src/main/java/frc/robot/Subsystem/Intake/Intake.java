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
     
    }

    public boolean Holdcanmove(){
      if(RobotContainer.getRobotState().getStateName() == RobotConstants.INTAKE.getStateName() &&  ) 
    }

    @Override
    public boolean CAN_MOVE() {
        return true;
    }

    public static final Intake getInstance() {
        if(intake == null) {
            intake = new Intake();
        }
        return intake;
    }

    

    
}
