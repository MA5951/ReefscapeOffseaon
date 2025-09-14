
package frc.robot.RobotControl;

import com.MAutils.Logger.MALog;

import frc.robot.RobotConstants;
import frc.robot.RobotContainer;
import frc.robot.RobotControl.Field.ScoringLocation;
import frc.robot.Subsystem.Intake.Intake;

public class SuperStructure {

    private static Field.ScoringLevel scoringLevel;
    private static Field.ScoringLocation scoringLocation;
    private static Field.BallHight ballHight;


    public static void setBallHeight(Field.BallHight newBallHight) {
        ballHight = newBallHight;
    }

    public static Field.BallHight getBallHeight() {
        return ballHight;
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
