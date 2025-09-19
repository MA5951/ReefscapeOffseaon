
package frc.robot.Subsystem.Arm;

import com.MAutils.Logger.MALog;
import com.MAutils.Subsystems.DeafultSubsystems.Systems.PositionControlledSystem;
import com.MAutils.Utils.ConvUtil;

import edu.wpi.first.math.geometry.Pose3d;
import edu.wpi.first.math.geometry.Rotation3d;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Robot;
import frc.robot.Subsystem.Elevator.Elevator;

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

    @Override
    public void periodic() {
        super.periodic();
        if (!Robot.isReal()) {
            MALog.log("/Simulation/Robot/Gripper Arm",
                    new Pose3d(0.3, 0, Elevator.getInstance().getPosition()  + 0.47,
                            new Rotation3d(0, ConvUtil.DegreesToRadians(-getPosition()), 0)));
        }
    }

    public static final Arm getInstance() {
        if (arm == null) {
            arm = new Arm();
        }
        return arm;
    }
}
