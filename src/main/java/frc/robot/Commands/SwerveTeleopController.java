
package frc.robot.Commands;

import com.MAutils.Swerve.SwerveSystemController;

import frc.robot.RobotContainer;
import frc.robot.Subsystem.Swerve.SwerveConstants;

public class SwerveTeleopController extends SwerveSystemController{

    public SwerveTeleopController() {
        super(RobotContainer.swerve, SwerveConstants.SWERVE_CONSTANTS, RobotContainer.getDriverController());
    }

    public void ConfigControllers() {
    }

    public void SetSwerveState() {

        if (RobotContainer.getDriverController().getL2() || RobotContainer.getDriverController().getR2()) {
            setState(SwerveConstants.POSE_ALIGN);
        } else {
            setState(SwerveConstants.FIELD_CENTRIC);
        }
        
    }

    public static boolean atPointForScoring() {
        return true;
    }
}