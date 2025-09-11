
package frc.robot.RobotControl;

import com.MAutils.Logger.MALog;

import frc.robot.Subsystem.Arm.Arm;
import frc.robot.Subsystem.Elevator.Elevator;

public class SuperStructure {

    private static Field.ScoringLevel scoringLevel;
    private static Field.ScoringLocation scoringLocation;


    private static final Arm arm = Arm.getInstance();
    private static final Elevator elevator = Elevator.getInstance();

    


    public static void setScoringPreset(Field.ScoringLevel ScoringLevel) {
        scoringLevel = ScoringLevel;
    }

    public static Field.ScoringLevel getScoringPreset() {
        return scoringLevel;
    }

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
        MALog.log("/SuperStructure/Scoring Location", ScoringLocation.name());
    }

    public static Field.ScoringLocation getScoringLocation() {
        return scoringLocation;
    }

    public static boolean isIntakeFliped() {
        return arm.getPosition() > 90;
    }

    public static double getElevatorHight() {
        return elevator.getPosition();
    }

}
