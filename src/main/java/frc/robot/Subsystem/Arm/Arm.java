
package frc.robot.Subsystem.Arm;

import com.MAutils.Subsystems.DeafultSubsystems.Systems.PositionControlledSystem;

import edu.wpi.first.wpilibj2.command.Command;

public class Arm extends PositionControlledSystem {
    private static Arm arm;

    private Arm() {
        super(ArmConstants.ARM_CONSTANTS);
    }

    @Override
    public Command getSelfTest() {
        return null;
    }

    @Override
    public boolean CAN_MOVE() {
        return true;
    }


    public static final Arm getInstance() {
        if (arm == null) {
            arm = new Arm();
        }
        return arm;
    }
}
