
package frc.robot.Subsystem.Elevator;

import com.MAutils.Logger.MALog;
import com.MAutils.Subsystems.DeafultSubsystems.Systems.PositionControlledSystem;

import edu.wpi.first.math.geometry.Pose3d;
import edu.wpi.first.math.geometry.Rotation3d;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Robot;

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

    @Override
    public void periodic() {
        super.periodic();
        if (!Robot.isReal()) {
            MALog.log("/Simulation/Robot/Elevator 1", new Pose3d(0, 0, getPosition() /2, new Rotation3d()));
            MALog.log("/Simulation/Robot/Elevator 2", new Pose3d(0, 0, getPosition() , new Rotation3d()));
        }
    }
  
    public static final Elevator getInstance() {
        if (elevator == null) {
            elevator = new Elevator();
        }
        return elevator;
    }
}


