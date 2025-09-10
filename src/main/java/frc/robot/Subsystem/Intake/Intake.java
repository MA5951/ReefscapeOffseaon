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

    public static final Intake getInstance() {
        if(intake == null) {
            intake = new Intake();
        }
        return intake;
    }
}
