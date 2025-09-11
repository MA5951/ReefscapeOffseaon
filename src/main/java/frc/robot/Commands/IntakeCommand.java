
package frc.robot.Commands;

import com.MAutils.RobotControl.SubsystemCommand;

import frc.robot.Subsystem.Arm.Arm;
import frc.robot.Subsystem.Arm.ArmConstants;
import frc.robot.Subsystem.Intake.Intake;
import frc.robot.Subsystem.Intake.IntakeConstants;

public class IntakeCommand extends SubsystemCommand {
    private static final Intake intake = Intake.getInstance();
    private boolean cycle = false;
    public static int i = 0;

    public IntakeCommand() {
        super(Intake.getInstance());
        addRequirements(intake);
    }

    @Override
    public void Automatic() {
        switch (intake.getCurrentState().stateName) {
            case "IDLE":
                intake.setVoltage(IntakeConstants.IDLE_VOLTS);
                break;
            case "CORAL_FORWARD":
                intake.setVoltage(IntakeConstants.CORAL_FORWARD_VOLTS);
                break;
            case "CORAL_EJECT":
                if (Arm.getInstance().getPosition() < ArmConstants.CORAL_EJECT_ANGLE) {
                    intake.setVoltage(IntakeConstants.CORAL_FORWARD_VOLTS);
                } else {
                    intake.setVoltage(IntakeConstants.CORAL_EJECT_VOLTS);
                }
                break;
            case "BALL_FORWARD":
                intake.setVoltage(IntakeConstants.BALL_FORWARD_VOLTS);
                break;
            case "BALL_BACKWARD":
                intake.setVoltage(IntakeConstants.BALL_BACKWARD_VOLTS);
                break;
            case "CORAL_HOLD":
                intake.setVoltage(IntakeConstants.CORAL_HOLD_VOLTS);
                break;
            case "BALL_HOLD":
                intake.setVoltage(IntakeConstants.BALL_HOLD_VOLTS);
                break;
            case "CORAL_SORTING":
                i = 0;
                if (cycle == true && !Intake.getRearSensor()) {
                    i++;
                    cycle = false;
                }
                if (Intake.getRearSensor()) {
                    cycle = true;
                    intake.setVoltage(IntakeConstants.CORAL_SORTING_BACKWARD_VOLTS);
                }
                if (!Intake.getRearSensor()) {
                    intake.setVoltage(IntakeConstants.CORAL_SORTING_FORWARD_VOLTS);
                }
                break;
            case "BALL_SORTING":  
                 i = 0;
                if (cycle == true && !Intake.getBallSensor()) {
                    i++;
                    cycle = false;
                }
        
                if (Intake.getBallSensor()) {
                    cycle = true;
                    intake.setVoltage(IntakeConstants.BALL_SORTING_BACKWARD_VOLTS);
                }
        
                if (!Intake.getBallSensor()) {
                    intake.setVoltage(IntakeConstants.BALL_SORTING_FORWARD_VOLTS);
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

