
package frc.robot.RobotControl;

import java.io.File;
import java.util.function.Supplier;

import com.MAutils.Logger.MALog;
import com.MAutils.PoseEstimation.PoseEstimator;
import com.MAutils.Vision.Util.LimelightHelpers.PoseEstimate;

import edu.wpi.first.math.geometry.Pose2d;
import edu.wpi.first.math.geometry.Rotation2d;
import frc.robot.RobotContainer;
import frc.robot.RobotControl.Field.ScoringLocation;
import frc.robot.Subsystem.Arm.Arm;
import frc.robot.Subsystem.Arm.ArmConstants;
import frc.robot.Subsystem.Intake.Intake;
import frc.robot.Subsystem.Intake.IntakeConstants;
import frc.robot.Subsystem.Vision.Vision;
import frc.robot.Subsystem.Vision.VisionConstants;
import frc.robot.Util.ReefFace;

public class SuperStructure {

    private static Field.ScoringLevel scoringLevel;
    private static Field.ScoringLocation scoringLocation = Field.ScoringLocation.LEFT;
    private static Field.BallHeight ballHeight;
    private static ReefFace bestReefFace;

    public static void setBallHeight(Field.BallHeight newBallHeight) {
        ballHeight = newBallHeight;
    }

    public static Field.BallHeight getBallHeight() {
        return ballHeight;
    }

    public static boolean isIntakeFlipped() {
        if (RobotContainer.arm.getPosition() < ArmConstants.FLIPPED_ANGLE) {
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
        return RobotContainer.intake.getBallSensor() < IntakeConstants.BALL_INTAKE_DISTANCE;
    }

    public static final boolean isAlgeaGoodForScoring() {
        return RobotContainer.intake.getBallSensor() < IntakeConstants.BALL_SCORING_DISTANCE;
    }

    public static final boolean isCoral() {
        return RobotContainer.intake.getFrontSensor() || RobotContainer.intake.getRearSensor();
    }

    public static final boolean isGamePiece() {
        return isCoral() || isAlgea();
    }

    public static void setScoringLocation(Field.ScoringLocation ScoringLocation) {
        scoringLocation = ScoringLocation;
        MALog.log("/SuperStructure/Scoring Location", ScoringLocation.name());
    }

    public static final Field.ScoringLocation getScoringLocation() {
        return scoringLocation;
    }


    public static double getAngleAdjustSetPoint() {
        return 180;
    }

    public static Pose2d getXYAdjustSetPoint() {
        if (scoringLocation == ScoringLocation.LEFT) {
            return bestReefFace.getLeftAlignPose();
        }

        return bestReefFace.getRightAlignPose();
    }

    public static void updateReefFace() {
        bestReefFace = Field.getBestMatchingReefFace(PoseEstimator.getCurrentPose());
    }

    public static ReefFace getBestReefFace() {
        return bestReefFace;
    }

    public static Pose2d getRelativXYSetPoint() {

        if (scoringLocation == ScoringLocation.LEFT) {
            return new Pose2d(13, -2, new Rotation2d());
        }

        return new Pose2d(11, -2.4, new Rotation2d());
    }

    public static int getTagID() {
        if(scoringLocation == ScoringLocation.LEFT) {
            return VisionConstants.fronRightLimelight.getCameraIO().getTag().id;
        }
        return VisionConstants.frontLeftLimelight.getCameraIO().getTag().id;
    }
    

}
