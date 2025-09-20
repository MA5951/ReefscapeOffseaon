
package frc.robot.Commands;

import com.MAutils.RobotControl.SubsystemCommand;

import frc.robot.RobotContainer;
import frc.robot.RobotControl.SuperStructure;
import frc.robot.Subsystem.Intake.Intake;
import frc.robot.Subsystem.Intake.IntakeConstants;

public class IntakeCommand extends SubsystemCommand {
    private static final Intake intake = RobotContainer.intake;
    private boolean cycle = false;
    public static int sortingCount = 0;// TODO: rename

    public IntakeCommand() {
        super(intake);
        addRequirements(intake);
    }

    @Override
    public void Automatic() {
        switch (intake.getCurrentState().stateName) {
            case "IDLE":
                intake.setVoltage(5);
                break;
            case "CORAL_INTAKE":
                intake.setVoltage(IntakeConstants.CORAL_INTAKE_VOLTS);
                break;
            case "CORAL_SCORING":
                intake.setVoltage(SuperStructure.getScoringPreset().ejectVolt);
            case "EJECT":
                if (SuperStructure.isAlgea()) {
                    intake.setVoltage(IntakeConstants.BALL_EJECT_VOLTS);
                } else if (SuperStructure.isIntakeFlipped()) {
                    intake.setVoltage(IntakeConstants.CORAL_EJECT_VOLTS);
                } else {
                    intake.setVoltage(IntakeConstants.CORAL_FORWARD_VOLTS);
                }
                break;
            case "BALL_INTAKE":
                intake.setVoltage(IntakeConstants.BALL_INTAKE_VOLTS);
                break;
            case "BALL_SCORING":
                if (SuperStructure.isAlgeaGoodForScoring()) {
                    intake.setVoltage(IntakeConstants.BALL_SCORING_VOLTS);
                } else {
                    intake.setVoltage(IntakeConstants.BALL_BEFORE_SCORING_VOLTS);
                }
                break;
            case "CORAL_HOLD":
                intake.setVoltage(IntakeConstants.CORAL_HOLD_VOLTS);
                break;
            case "BALL_HOLD":
                if (RobotContainer.intake.getBallSensor() < IntakeConstants.BALL_HOLDING_MIN_DISTANCE)
                    intake.setVoltage(IntakeConstants.BALL_HOLD_FORWARD_VOLTS);
                else if (RobotContainer.intake.getBallSensor() > IntakeConstants.BALL_HOLDING_MAX_DISTANCE)
                    intake.setVoltage(IntakeConstants.BALL_HOLD_BACKWARD_VOLTS);
                else
                    break;
            case "CORAL_SORTING":
                sortingCount = 0;
                if (cycle == true && !RobotContainer.intake.getRearSensor()) {
                    sortingCount++;
                    cycle = false;
                }
                if (RobotContainer.intake.getRearSensor()) {
                    cycle = true;
                    intake.setVoltage(IntakeConstants.CORAL_SORTING_BACKWARD_VOLTS);
                }
                if (!RobotContainer.intake.getRearSensor()) {
                    intake.setVoltage(IntakeConstants.CORAL_SORTING_FORWARD_VOLTS);
                }
                break;

        }
    }

    @Override
    public void Manual() {

    }

    @Override
    public void CantMove() {
        intake.setVoltage(0);
    }

}
