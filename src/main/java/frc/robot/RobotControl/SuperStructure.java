
package frc.robot.RobotControl;

import com.MAutils.Logger.MALog;

import frc.robot.RobotConstants;
import frc.robot.RobotContainer;
import frc.robot.RobotControl.Field.ScoringLocation;
import frc.robot.Subsystem.Arm.Arm;
import frc.robot.Subsystem.Arm.ArmConstants;
import frc.robot.Subsystem.Intake.Intake;
import frc.robot.Subsystem.Intake.IntakeConstants;

public class SuperStructure {

    private static Field.ScoringLevel scoringLevel;
    private static Field.ScoringLocation scoringLocation;
    private static Field.BallHieght ballHeight;


    public static void setBallHeight(Field.BallHieght newBallHeight) {
        ballHeight = newBallHeight;
    }

    public static Field.BallHieght getBallHeight() {
        return ballHeight;
    }

    public static boolean isIntakeFlipped() {
        if (Arm.getInstance().getPosition() < ArmConstants.FLIPPED_ANGLE) {
            return false;
        } else {
            return true;
        }
    }


    public static void setScoringPreset(Field.ScoringLevel ScoringLevel) {
        scoringLevel = ScoringLevel;
    }

    public static Field.ScoringLevel getScoringPreset() {
        return scoringLevel;
    }


    public static final boolean isAlgea() {
        return true;
    }

    public static final boolean isCoral() {
        return Intake.getInstance().getFrontSensor() || Intake.getInstance().getRearSensor();
    }

    public static final boolean isGamePiece() {
        return isCoral() || isAlgea();
    }

    public static void setScoringLocation(Field.ScoringLocation ScoringLocation) {
        scoringLocation = ScoringLocation;
        MALog.log("/SuperStructure/Scoring Location", ScoringLocation.name());
    }

}
