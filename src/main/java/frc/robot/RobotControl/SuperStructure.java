
package frc.robot.RobotControl;

import com.MAutils.Logger.MALog;

import edu.wpi.first.math.geometry.Pose2d;
import edu.wpi.first.math.geometry.Rotation2d;
import frc.robot.Subsystem.Arm.Arm;
import frc.robot.Subsystem.Arm.ArmConstants;
import frc.robot.Subsystem.Intake.Intake;
import frc.robot.Subsystem.Intake.IntakeConstants;

public class SuperStructure {

    private static Field.ScoringLevel scoringLevel;
    private static Field.ScoringLocation scoringLocation;
    private static Field.BallHeight ballHeight;

    public static void setBallHeight(Field.BallHeight newBallHeight) {
        ballHeight = newBallHeight;
    }

    public static Field.BallHeight getBallHeight() {
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
        return Intake.getInstance().getBallSensor() < IntakeConstants.BALL_INTAKE_DISTANCE;
    }

    public static final boolean isAlgeaGoodForScoring() {
        return Intake.getInstance().getBallSensor() < IntakeConstants.BALL_SCORING_DISTANCE;
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


    public static double getAngleAdjustSetPoint() {
        return 180;
    }

    public static Pose2d getXYAdjustSetPoint() {
        return new Pose2d(1,5,new Rotation2d());
    }

    

}
