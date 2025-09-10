package frc.robot.Subsystem.Climb;

import com.MAutils.Subsystems.DeafultSubsystems.Systems.PositionControlledSystem;

import edu.wpi.first.wpilibj2.command.Command;

public class Climb extends PositionControlledSystem {
    private static Climb climb;

    private Climb() {
        super(ClimbConstants.CLIMB_CONSTANTS);
    }

    @Override
    public Command getSelfTest() {
        return null;
    }

    @Override
    public boolean CAN_MOVE() {
        return true;
    }

    public static Climb getInstance() {
        if(climb == null) {
            climb = new Climb();
        }
        return climb;
    }
}
