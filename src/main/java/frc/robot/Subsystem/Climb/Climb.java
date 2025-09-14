package frc.robot.Subsystem.Climb;

import com.MAutils.RobotControl.DeafultRobotContainer;
import com.MAutils.Subsystems.DeafultSubsystems.Systems.PositionControlledSystem;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.RobotConstants;
import frc.robot.RobotContainer;

public class Climb extends PositionControlledSystem {
    private static Climb climb;

    private Climb() {
        super(ClimbConstants.CLIMB_CONSTANTS);
    }

    @Override
    public Command getSelfTest() {
        return null;
    }
    public boolean isatHoldPosition(){
        return false;
    }

public  boolean preClimbingCanMove(){
    if (RobotContainer.getRobotState().getStateName() == RobotConstants.PRECLIMBING.getStateName() && climb.getPosition() <= ClimbConstants.OPEN_ANGLE){
        return true;
    } else {
        return false;
    }
}
// need to add servo open
public boolean climbingCanMove(){
    if (RobotContainer.getRobotState().getStateName() == RobotConstants.CLIMBING.getStateName() && climb.getPosition() >= ClimbConstants.OPEN_ANGLE){
        return true;
    } else {
        return false;
    }
}


public boolean restartCanMove(){
    if (RobotContainer.getRobotState().getStateName() != RobotConstants.CLIMBING.getStateName() && !isatHoldPosition()){
        return true;
    } else {
        return false;
    }
}


    @Override
    public boolean CAN_MOVE() {
        return preClimbingCanMove() || climbingCanMove() || restartCanMove();
    }

    public static Climb getInstance() {
        if(climb == null) {
            climb = new Climb();
        }
        return climb;
    }
}
