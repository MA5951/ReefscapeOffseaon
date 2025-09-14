
package frc.robot.Command;

import com.MAutils.RobotControl.SubsystemCommand;

import frc.robot.Subsystem.Climb.Climb;
import frc.robot.Subsystem.Climb.ClimbConstants;

public class ClimbingCommand extends SubsystemCommand {
    private static final Climb climb = Climb.getInstance();

    public ClimbingCommand() {
        super(climb);
        addRequirements(climb);
    }

    @Override
    public void Automatic() {
        switch (climb.getCurrentState().stateName) {
            case "IDLE":
                climb.setPosition(ClimbConstants.IDLE_ANGLE);
                break;
            case "OPEN":
                climb.setPosition(ClimbConstants.OPEN_ANGLE);
                break;
            case "CLOSE":
                climb.setPosition(ClimbConstants.CLOSE_ANGLE);
                break;
            case "RSET":
                climb.setVoltage(ClimbConstants.RESER_VOLTS);
                break;                
        }
    }

    @Override
    public void Manual() {
        
    }

    @Override
    public void CantMove() {
        climb.setVoltage(0);
    }
}
