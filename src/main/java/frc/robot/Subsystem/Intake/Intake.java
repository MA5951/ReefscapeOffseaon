package frc.robot.Subsystem.Intake;

import com.MAutils.Subsystems.DeafultSubsystems.Systems.PowerControlledSystem;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Commands.SwerveTeleopController;
import frc.robot.PortMap;
import frc.robot.RobotConstants;
import frc.robot.RobotContainer;
import frc.robot.RobotControl.SuperStructure;

public class Intake extends PowerControlledSystem {

    private static Intake intake = null;
    // private final DigitalInput frontSensor;
    // private final DigitalInput rearSensor;

    private Intake() {
        super(IntakeConstants.INTAKE_CONSTANTS);

        
    }

    @Override
    public Command getSelfTest() {
        return null;
    }

    @Override
    public boolean CAN_MOVE() {
        return (RobotContainer.getRobotState() == RobotConstants.INTAKE && !SuperStructure.isGamePiece()) 
                || (RobotContainer.getRobotState() == RobotConstants.CORAL_HOLD && SuperStructure.isCoral())
                || (RobotContainer.getRobotState() == RobotConstants.SCORING && SuperStructure.isGamePiece()
                        && RobotContainer.elevator.atPoint() && RobotContainer.arm.atPoint()
                        && SwerveTeleopController.atPointForScoring())
                || (RobotContainer.getRobotState() == RobotConstants.EJECT && SuperStructure.isGamePiece())
                || (RobotContainer.getRobotState() == RobotConstants.BALL_INTAKE)
                || (RobotContainer.getRobotState() == RobotConstants.BALL_HOLDING)
                || (RobotContainer.getRobotState() == RobotConstants.BALL_PRESCORING)
                || (RobotContainer.getRobotState() == RobotConstants.BALL_SCORING)
                || (RobotContainer.getRobotState() == RobotConstants.SORTING && getFrontSensor());
    }

    public boolean getRearSensor() {
        //return !rearSensor.get();
        return false;
    }

    public boolean getFrontSensor() {
        //return !frontSensor.get();
        return false;
    }

    public double getBallSensor() {
        return 0;
    }

    public static final Intake getInstance() {
        if (intake == null) {
            intake = new Intake();
        }
        return intake;
    }

}
