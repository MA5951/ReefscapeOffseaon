
package frc.robot.Commands;

import com.MAutils.RobotControl.SubsystemCommand;

import frc.robot.RobotContainer;
import frc.robot.RobotControl.SuperStructure;
import frc.robot.Subsystem.Arm.Arm;
import frc.robot.Subsystem.Arm.ArmConstants;

public class ArmCommand extends SubsystemCommand {
    private static final Arm arm = RobotContainer.arm;

    public ArmCommand() {
        super(arm);
        addRequirements(arm);
    }

    @Override
    public void Automatic() {
        switch (arm.getCurrentState().stateName) {
            case "IDLE":
                arm.setPosition(90);
                break;
            case "INTAKE":
                arm.setPosition(ArmConstants.INTAKE_ANGLE);
                break;
            case "CORAL_SCORING":
                arm.setPosition(SuperStructure.getScoringPreset().angle);
                break;
            case "BALL_INTAKE":
                arm.setPosition(ArmConstants.BALL_INTAKE_ANGLE);
                break;
            case "BALL_HOLDING":
                arm.setPosition(ArmConstants.BALL_HOLDING_ANGLE);
                break;
            case "BALL_PRESCORING":
                arm.setPosition(ArmConstants.BALL_PRESCORING_ANGLE);
                break;
            case "BALL_SCORING":
                arm.setPosition(ArmConstants.BALL_SCORING_ANGLE);
                break;
            case "CORAL_HOLDING":
                arm.setPosition(ArmConstants.CORAL_HOLDING_ANGLE);
                break;
        }
    }

    @Override
    public void Manual() {

    }

    @Override
    public void CantMove() {

    }
    
}
