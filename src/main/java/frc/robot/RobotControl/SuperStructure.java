
package frc.robot.RobotControl;

import com.MAutils.Logger.MALog;

import frc.robot.RobotConstants;
import frc.robot.RobotContainer;
import frc.robot.RobotControl.Field.ScoringLocation;

public class SuperStructure {

    private static Field.ScoringLevel scoringLevel;
    private static Field.ScoringLocation scoringLocation;


    //TODO: add get BallHight


    public static void setScoringPreset(Field.ScoringLevel ScoringLevel) {
        scoringLevel = ScoringLevel;
    }

    public static Field.ScoringLevel getScoringPreset() {
        return scoringLevel;
    }

    //TODO: remove
    public static final boolean istFrontSensore() {
        return true;
    }

    public static final boolean isRearSensore() {
        return true;
    }

    public static final boolean isAlgea() {
        return true;
    }

    public static final boolean isCoral() {
        return isRearSensore() || istFrontSensore();
    }

    public static final boolean isGamePiece() {
        return isCoral() || isAlgea();
    }

    public static void setScoringLocation(Field.ScoringLocation ScoringLocation) {
        scoringLocation = ScoringLocation;
        //MALog("/SuperStructure/Scoring Location", ScoringLocation.name());
    }

}
