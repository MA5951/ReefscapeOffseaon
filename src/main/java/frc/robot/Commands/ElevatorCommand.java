package frc.robot.Commands;

import com.MAutils.RobotControl.SubsystemCommand;

import frc.robot.Subsystem.Elevator.Elevator;
import frc.robot.Subsystem.Elevator.ElevatorConstants;

public class ElevatorCommand extends SubsystemCommand {
    private static final Elevator elveator = Elevator.getInstance();

    public ElevatorCommand() {
        super(elveator);
        addRequirements(elveator);
    }

    @Override
    public void Automatic() {
        switch (elveator.getCurrentState().stateName) {
            case "IDLE":
                elveator.setPosition(ElevatorConstants.IDLE_HEIGHT);
                break;
            case "INTAKE":
                elveator.setPosition(ElevatorConstants.INTAKE_HEIGHT);
                break;
            case "SCORING":
                elveator.setPosition(Elevator.getHeight());
                break;
            case "BALL_INTAKE":
                elveator.setPosition(Elevator.getBallHeight());
                break;
            case "BALL_HOLDING":
                elveator.setPosition(ElevatorConstants.BALL_HOLDING_HEIGHT);
                break;
            case "BALL_SCORING":
                elveator.setPosition(ElevatorConstants.BALL_SCORING_HEIGHT);
                break;
            case "CLOSE":
                elveator.setPosition(ElevatorConstants.CLOSE_HEIGHT);
                break;
            case "HOLD":
                elveator.setPosition(ElevatorConstants.HOLDING_HEIGHT);

        }
    }

    @Override
    public void Manual() {

    }

    @Override
    public void CantMove() {
        
    }

}
