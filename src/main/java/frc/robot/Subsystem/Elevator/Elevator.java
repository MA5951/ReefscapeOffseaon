
package frc.robot.Subsystem.Elevator;

import com.MAutils.Subsystems.DeafultSubsystems.Systems.PositionControlledSystem;

import edu.wpi.first.wpilibj2.command.Command;

public class Elevator extends PositionControlledSystem {
    private static Elevator elevator;

    private Elevator() {
        super(ElevatorConstants.ELEVATOR_CONSTANTS);
    }

    @Override
    public Command getSelfTest() {
        return null;
    }

    @Override
    public boolean CAN_MOVE() {
        return true;
    }

    public static int getHeight() {
        return 1;
    }

   public static int getBallHeight() {
    return 1;
   }
    public static final Elevator getInstance() {
        if (elevator == null) {
            elevator = new Elevator();
        }
        return elevator;
    }
}


