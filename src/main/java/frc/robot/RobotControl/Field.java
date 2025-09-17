package frc.robot.RobotControl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import org.ironmaple.utils.FieldMirroringUtils;

import com.MAutils.Utils.DriverStationUtil;

import edu.wpi.first.math.geometry.Ellipse2d;
import edu.wpi.first.math.geometry.Pose2d;
import edu.wpi.first.math.geometry.Rectangle2d;
import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.geometry.Translation2d;
import edu.wpi.first.math.util.Units;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.DriverStation.Alliance;
import frc.robot.Subsystem.Arm.ArmConstants;
import frc.robot.Subsystem.Elevator.ElevatorConstants;
import frc.robot.Subsystem.Intake.IntakeConstants;
import frc.robot.Util.ReefFace;

public class Field {

    // ---------------- ENUMS ----------------
    public static enum GamePiece { CORAL, BALL, NONE }
    public static enum ScoringLocation { LEFT, RIGHT, NONE }

    public static enum ScoringLevel {
        L1(ElevatorConstants.HEIGHT_L1, ArmConstants.ANGLE_L1, IntakeConstants.EJECT_SPEED_L1),
        L2(ElevatorConstants.HEIGHT_L2, ArmConstants.ANGLE_L2, IntakeConstants.EJECT_SPEED_L234),
        L3(ElevatorConstants.HEIGHT_L3, ArmConstants.ANGLE_L3, IntakeConstants.EJECT_SPEED_L234),
        L4(ElevatorConstants.HEIGHT_L4, ArmConstants.ANGLE_L4, IntakeConstants.EJECT_SPEED_L234 - 3.5);

        public final double height;
        public final double angle;
        public final double ejectVolt;

        ScoringLevel(double h, double a, double e) {
            height = h; angle = a; ejectVolt = e;
        }
    }

    public static enum BallHeight {
        HIGH(ElevatorConstants.BALL_HIGH_INTAKE_HEIGHT),
        LOW(ElevatorConstants.BALL_LOW_INTAKE_HEIGHT),
        NONE(0);

        public final double elevatorHeight;
        BallHeight(double h) { elevatorHeight = h; }
    }

    public static void setAllianceReefFaces(Alliance alliance) {
        if (!wasFieldSet) {
            wasFieldSet = true;
            if (alliance == Alliance.Blue) {
                // Blue Side
                ReefFaces.put(17, new ReefFace(Tag17Pose.getRotation().getDegrees(), 17,
                                Field.BallHeight.LOW, Tag17Pose));
                ReefFaces.put(22, new ReefFace(Tag22Pose.getRotation().getDegrees(), 22,
                                Field.BallHeight.HIGH, Tag22Pose));
                ReefFaces.put(20, new ReefFace(Tag20Pose.getRotation().getDegrees(), 20,
                                Field.BallHeight.HIGH, Tag20Pose));
                ReefFaces.put(19, new ReefFace(Tag19Pose.getRotation().getDegrees(), 19,
                                Field.BallHeight.LOW, Tag19Pose));
                ReefFaces.put(18, new ReefFace(Tag18Pose.getRotation().getDegrees(), 18,
                                Field.BallHeight.HIGH, Tag18Pose));
                ReefFaces.put(21, new ReefFace(Tag21Pose.getRotation().getDegrees(), 21,
                                Field.BallHeight.LOW, Tag21Pose));
                ReefTags.add(17);
                ReefTags.add(22);
                ReefTags.add(20);
                ReefTags.add(19);
                ReefTags.add(18);
                ReefTags.add(21);
            } else {
                // Red Side
                ReefFaces.put(10, new ReefFace(Tag10Pose.getRotation().getDegrees(), 10,
                                Field.BallHeight.LOW, Tag10Pose));
                ReefFaces.put(7, new ReefFace(Tag7Pose.getRotation().getDegrees(), 7,
                                Field.BallHeight.HIGH, Tag7Pose));
                ReefFaces.put(11, new ReefFace(Tag11Pose.getRotation().getDegrees(), 11,
                                Field.BallHeight.HIGH, Tag11Pose));
                ReefFaces.put(9, new ReefFace(Tag9Pose.getRotation().getDegrees(), 9,
                                Field.BallHeight.HIGH, Tag9Pose));
                ReefFaces.put(8, new ReefFace(Tag8Pose.getRotation().getDegrees(), 8,
                                Field.BallHeight.LOW, Tag8Pose));
                ReefFaces.put(6, new ReefFace(Tag6Pose.getRotation().getDegrees(), 6,
                                Field.BallHeight.LOW, Tag6Pose));
                ReefTags.add(10);
                ReefTags.add(7);
                ReefTags.add(11);
                ReefTags.add(9);
                ReefTags.add(8);
                ReefTags.add(6);
            }
        }
    }
    

    // ---------------- CONSTANTS ----------------
    public static final Translation2d FieldZeroCorner = new Translation2d(0, 0);
    public static final Translation2d FieldFarCorner = new Translation2d(17.548, 8.052);
    public static final Translation2d FieldMiddlePoint = new Translation2d(17.548 / 2, 8.052 / 2);
    public static final Rectangle2d FieldRectangle = new Rectangle2d(FieldZeroCorner, FieldFarCorner);

    public static final Ellipse2d BLUE_REEF_CIRCLE =
        new Ellipse2d(new Translation2d(3.6576 + 0.831596, 4.0259), 0.9);
    public static final Ellipse2d RED_REEF_CIRCLE =
        new Ellipse2d(new Translation2d(12.227306 + 0.831596, 4.0259), 0.9);

    public static final Translation2d ReefCenterBlue = new Translation2d(4.45, 4);
    public static final Translation2d ReefCenterRed  = new Translation2d(4.45, 13.2);
    public static final Translation2d ReefCenter =
        DriverStationUtil.getAlliance() == Alliance.Blue ? ReefCenterBlue : ReefCenterRed;

    // ---------------- POSES ----------------
    public static final Pose2d Tag6Pose  = new Pose2d(13.474446, 3.306318, Rotation2d.fromDegrees(120));
    public static final Pose2d Tag7Pose  = new Pose2d(13.890498, 4.0259,   Rotation2d.fromDegrees(180));
    public static final Pose2d Tag8Pose  = new Pose2d(13.474446, 4.745482, Rotation2d.fromDegrees(-120));
    public static final Pose2d Tag9Pose  = new Pose2d(12.643358, 4.745482, Rotation2d.fromDegrees(-60));
    public static final Pose2d Tag10Pose = new Pose2d(12.227306, 4.0259,   new Rotation2d(0));
    public static final Pose2d Tag11Pose = new Pose2d(12.643358, 3.306318, Rotation2d.fromDegrees(60));

    public static final Pose2d Tag17Pose = new Pose2d(4.073906, 3.306318, Rotation2d.fromDegrees(60));
    public static final Pose2d Tag18Pose = new Pose2d(3.6576,   4.0259,   new Rotation2d(0));
    public static final Pose2d Tag19Pose = new Pose2d(4.073906, 4.745482, Rotation2d.fromDegrees(-60));
    public static final Pose2d Tag20Pose = new Pose2d(4.90474,  4.745482, Rotation2d.fromDegrees(-120));
    public static final Pose2d Tag21Pose = new Pose2d(5.321046, 4.0259,   Rotation2d.fromDegrees(180));
    public static final Pose2d Tag22Pose = new Pose2d(4.90474,  3.306318, Rotation2d.fromDegrees(120));

    // ---------------- MAPS ----------------
    public static HashMap<Integer, ReefFace> ReefFaces = new HashMap<>();
    public static ReefFace blankFace = new ReefFace(0, 0, BallHeight.NONE, new Pose2d());
    public final static List<Integer> ReefTags = new ArrayList<>();

    private static ReefFace closestFace;
    private static double closestDistanceReef;
    private static double spatialDistanceReef;
    private static boolean wasFieldSet = false;

    // ---------------- REUSABLE VARIABLES for getBestMatchingReefFace ----------------
    private static final double maxHeadingDiff = 180.0;
    private static double robotX, robotY, robotHeading;
    private static double dx, dy, dist;
    private static double headingDiff, headingScore, distanceScore, score;
    private static double maxDistance, bestScore;
    private static ReefFace bestFace;

    // ---------------- FUNCTIONS ----------------
    public static ReefFace getClosestReefFace(Pose2d robotPose) {
        if (wasFieldSet) {
            closestFace = null;
            closestDistanceReef = Double.MAX_VALUE;

            for (ReefFace face : ReefFaces.values()) {
                spatialDistanceReef = euclideanDistance(robotPose, face.tagPose());
                if (spatialDistanceReef < closestDistanceReef) {
                    closestDistanceReef = spatialDistanceReef;
                    closestFace = face;
                }
            }
            return closestFace;
        }
        return blankFace;
    }

    public static double euclideanDistance(Pose2d pose1, Pose2d pose2) {
        return Math.sqrt(
            Math.pow(pose1.getX() - pose2.getX(), 2) +
            Math.pow(pose1.getY() - pose2.getY(), 2)
        );
    }

    // ---------------- NEW FUNCTION ----------------
    public static ReefFace getBestMatchingReefFace(Pose2d robotPose) {
        if (!wasFieldSet || ReefFaces.isEmpty()) {
            return blankFace;
        }

        // Cache robot pose
        robotX = robotPose.getX();
        robotY = robotPose.getY();
        robotHeading = robotPose.getRotation().getDegrees();

        // First pass: find max distance
        maxDistance = 0.0;
        for (ReefFace face : ReefFaces.values()) {
            dx = robotX - face.tagPose().getX();
            dy = robotY - face.tagPose().getY();
            dist = Math.sqrt(dx * dx + dy * dy);
            if (dist > maxDistance) maxDistance = dist;
        }
        if (maxDistance == 0) maxDistance = 1.0;

        // Second pass: find best face
        bestFace = null;
        bestScore = Double.MAX_VALUE;

        for (ReefFace face : ReefFaces.values()) {
            // Heading diff
            headingDiff = Math.abs(robotHeading - face.AbsAngle());
            if (headingDiff > 180) headingDiff = 360 - headingDiff;

            // Distance
            dx = robotX - face.tagPose().getX();
            dy = robotY - face.tagPose().getY();
            dist = Math.sqrt(dx * dx + dy * dy);

            // Normalized
            headingScore = headingDiff / maxHeadingDiff;
            distanceScore = dist / maxDistance;

            // Weighted sum (tune as needed)
            score = 0.3 * headingScore + 0.7 * distanceScore;

            if (score < bestScore) {
                bestScore = score;
                bestFace = face;
            }
        }

        return bestFace != null ? bestFace : blankFace;
    }
}
