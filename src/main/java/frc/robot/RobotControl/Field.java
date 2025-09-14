
package frc.robot.RobotControl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.MAutils.Utils.DriverStationUtil;

import edu.wpi.first.math.geometry.Ellipse2d;
import edu.wpi.first.math.geometry.Pose2d;
import edu.wpi.first.math.geometry.Rectangle2d;
import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.geometry.Translation2d;
import edu.wpi.first.wpilibj.DriverStation.Alliance;
import frc.robot.RobotConstants;
import frc.robot.Subsystem.Arm.ArmConstants;
import frc.robot.Subsystem.Elevator.ElevatorConstants;
import frc.robot.Subsystem.Intake.IntakeConstants;
import frc.robot.Util.ReefFace;

public class Field {

        public static enum GamePiece {
                CORAL(),
                BALL(),
                NONE();

                GamePiece() {
                }

        }

        public static enum ScoringLevel {
                L1(ElevatorConstants.HEIGHT_L1, ArmConstants.ANGLE_L1, IntakeConstants.EJECT_SPEED_L1),

                L2(ElevatorConstants.HEIGHT_L2, ArmConstants.ANGLE_L2, IntakeConstants.EJECT_SPEED_L234),

                L3(ElevatorConstants.HEIGHT_L3, ArmConstants.ANGLE_L3, IntakeConstants.EJECT_SPEED_L234),

                L4(ElevatorConstants.HEIGHT_L4, ArmConstants.ANGLE_L4, IntakeConstants.EJECT_SPEED_L234 - 3.5);

                public final double hieght;
                public final double angle;
                public final double ejectVolt;

                ScoringLevel(double ScoringHieght, double ScoringAngle, double EjectVolt) {
                        hieght = ScoringHieght;
                        angle = ScoringAngle;
                        ejectVolt = EjectVolt;
                }
        }

        public static enum ScoringLocation {
                LEFT(),
                RIGHT(),
                NONE();

        }

        public static enum BallHieght {
                HIGH(ElevatorConstants.BALL_HEIGHT_INTAKE), // HIGHT_EJECT_BALL_HIGH
                LOW(ElevatorConstants.BALL_HEIGHT_INTAKE),
                NONE(0);

                public final double elevatorHieght;

                BallHieght(double ElevatorHieght) {
                        elevatorHieght = ElevatorHieght;
                }
        }

        // FieldConstants
        public static final Translation2d FieldZeroCorner = new Translation2d(0, 0);
        public static final Translation2d FieldFarCorner = new Translation2d(17.548, 8.052);
        public static final Translation2d FieldMiddlePoint = new Translation2d(17.548 / 2, 8.052 / 2);
        public static final Rectangle2d FieldRectangle = new Rectangle2d(FieldZeroCorner, FieldFarCorner);
        public static final Ellipse2d BLUE_REEF_CIRCLE = new Ellipse2d(new Translation2d(3.6576 + 0.831596, 4.0259),
                        0.9);
        public static final Ellipse2d RED_REEF_CIRCLE = new Ellipse2d(
                        new Translation2d(12.227305999999999 + 0.831596, 4.0259), 0.9);
        public static final Translation2d ReefCenterBlue = new Translation2d(4.45, 4);// TODO
        public static final Translation2d ReefCenterRed = new Translation2d(4.45, 13.2);// TODO
        public static final Translation2d ReefCenter = DriverStationUtil.getAlliance() == Alliance.Blue ? ReefCenterBlue
                        : ReefCenterRed;

        // Reef
        public static final Pose2d Tag6Pose = new Pose2d(13.474446, 3.3063179999999996, Rotation2d.fromDegrees(120));
        public static final Pose2d Tag7Pose = new Pose2d(13.890498, 4.0259, Rotation2d.fromDegrees(180));
        public static final Pose2d Tag8Pose = new Pose2d(13.474446, 4.745482, Rotation2d.fromDegrees(-120));
        public static final Pose2d Tag9Pose = new Pose2d(12.643358, 4.745482, Rotation2d.fromDegrees(-60));
        public static final Pose2d Tag10Pose = new Pose2d(12.227305999999999, 4.0259, new Rotation2d(0));
        public static final Pose2d Tag11Pose = new Pose2d(12.643358, 3.3063179999999996, Rotation2d.fromDegrees(60));

        public static final Pose2d Tag17Pose = new Pose2d(4.073905999999999, 3.3063179999999996,
                        Rotation2d.fromDegrees(60));
        public static final Pose2d Tag18Pose = new Pose2d(3.6576, 4.0259, new Rotation2d(0));
        public static final Pose2d Tag19Pose = new Pose2d(4.073905999999999, 4.745482, Rotation2d.fromDegrees(-60));
        public static final Pose2d Tag20Pose = new Pose2d(4.904739999999999, 4.745482, Rotation2d.fromDegrees(-120));
        public static final Pose2d Tag21Pose = new Pose2d(5.321046, 4.0259, Rotation2d.fromDegrees(180));
        public static final Pose2d Tag22Pose = new Pose2d(4.904739999999999, 3.3063179999999996,
                        Rotation2d.fromDegrees(120));

        // Source
        public static final Pose2d Tag1Pose = new Pose2d(16.697198, 0.65532, Rotation2d.fromDegrees(-52));
        public static final Pose2d Tag2Pose = new Pose2d(16.697198, 7.3964799999999995, Rotation2d.fromDegrees(52));
        public static final Pose2d Tag12Pose = new Pose2d(0.851154, 0.65532, Rotation2d.fromDegrees(-127));
        public static final Pose2d Tag13Pose = new Pose2d(0.851154, 7.3964799999999995, Rotation2d.fromDegrees(127));

        private static HashMap<Integer, ReefFace> ReefFaces = new HashMap<Integer, ReefFace>();
        private static ReefFace blankFace = new ReefFace(0, 0, BallHieght.NONE, new Pose2d());
        public final static List<Integer> ReefTags = new ArrayList<>();
        private static ReefFace closestFace;
        private static double closestDistanceReef;
        private static double spatialDistanceReef;
        private static boolean wasFieldSet = false;

        public Field() {
                // Blue Side
                ReefFaces.put(17,
                                new ReefFace(Tag17Pose.getRotation().getDegrees(), 17,
                                                Field.BallHieght.LOW,
                                                Tag17Pose));
                ReefFaces.put(22,
                                new ReefFace(Tag22Pose.getRotation().getDegrees(), 22,
                                                Field.BallHieght.HIGH,
                                                Tag22Pose));
                ReefFaces.put(20,
                                new ReefFace(Tag20Pose.getRotation().getDegrees(), 20,
                                                Field.BallHieght.HIGH,
                                                Tag20Pose));
                ReefFaces.put(19,
                                new ReefFace(Tag19Pose.getRotation().getDegrees(), 19,
                                                Field.BallHieght.LOW,
                                                Tag19Pose));
                ReefFaces.put(18,
                                new ReefFace(Tag18Pose.getRotation().getDegrees(), 18,
                                                Field.BallHieght.HIGH,
                                                Tag18Pose));
                ReefFaces.put(21,
                                new ReefFace(Tag21Pose.getRotation().getDegrees(), 21,
                                                Field.BallHieght.LOW,
                                                Tag21Pose));
                ReefTags.add(17);
                ReefTags.add(22);
                ReefTags.add(20);
                ReefTags.add(19);
                ReefTags.add(18);
                ReefTags.add(21);

                ReefFaces.put(10,
                                new ReefFace(Tag10Pose.getRotation().getDegrees(), 10,
                                                Field.BallHieght.LOW,
                                                Tag10Pose));
                ReefFaces.put(7, new ReefFace(Tag7Pose.getRotation().getDegrees(), 7,
                                Field.BallHieght.HIGH,
                                Tag7Pose));
                ReefFaces.put(11,
                                new ReefFace(Tag11Pose.getRotation().getDegrees(), 11,
                                                Field.BallHieght.HIGH,
                                                Tag11Pose));
                ReefFaces.put(9, new ReefFace(Tag9Pose.getRotation().getDegrees(), 9,
                                Field.BallHieght.HIGH,
                                Tag9Pose));
                ReefFaces.put(8, new ReefFace(Tag8Pose.getRotation().getDegrees(), 8,
                                Field.BallHieght.LOW,
                                Tag8Pose));
                ReefFaces.put(6, new ReefFace(Tag6Pose.getRotation().getDegrees(), 6,
                                Field.BallHieght.LOW,
                                Tag6Pose));
                ReefTags.add(10);
                ReefTags.add(7);
                ReefTags.add(11);
                ReefTags.add(9);
                ReefTags.add(8);
                ReefTags.add(6);

                wasFieldSet = true;
        }

        public static void setAllianceReefFaces(Alliance alliance) {
                if (!wasFieldSet) {
                        wasFieldSet = true;
                        if (alliance == Alliance.Blue) {
                                // Blue Side
                                ReefFaces.put(17, new ReefFace(Tag17Pose.getRotation().getDegrees(), 17,
                                                Field.BallHieght.LOW, Tag17Pose));
                                ReefFaces.put(22, new ReefFace(Tag22Pose.getRotation().getDegrees(), 22,
                                                Field.BallHieght.HIGH, Tag22Pose));
                                ReefFaces.put(20, new ReefFace(Tag20Pose.getRotation().getDegrees(), 20,
                                                Field.BallHieght.HIGH, Tag20Pose));
                                ReefFaces.put(19, new ReefFace(Tag19Pose.getRotation().getDegrees(), 19,
                                                Field.BallHieght.LOW, Tag19Pose));
                                ReefFaces.put(18, new ReefFace(Tag18Pose.getRotation().getDegrees(), 18,
                                                Field.BallHieght.HIGH, Tag18Pose));
                                ReefFaces.put(21, new ReefFace(Tag21Pose.getRotation().getDegrees(), 21,
                                                Field.BallHieght.LOW, Tag21Pose));
                                ReefTags.add(17);
                                ReefTags.add(22);
                                ReefTags.add(20);
                                ReefTags.add(19);
                                ReefTags.add(18);
                                ReefTags.add(21);
                        } else {
                                // Red Side
                                ReefFaces.put(10, new ReefFace(Tag10Pose.getRotation().getDegrees(), 10,
                                                Field.BallHieght.LOW, Tag10Pose));
                                ReefFaces.put(7, new ReefFace(Tag7Pose.getRotation().getDegrees(), 7,
                                                Field.BallHieght.HIGH, Tag7Pose));
                                ReefFaces.put(11, new ReefFace(Tag11Pose.getRotation().getDegrees(), 11,
                                                Field.BallHieght.HIGH, Tag11Pose));
                                ReefFaces.put(9, new ReefFace(Tag9Pose.getRotation().getDegrees(), 9,
                                                Field.BallHieght.HIGH, Tag9Pose));
                                ReefFaces.put(8, new ReefFace(Tag8Pose.getRotation().getDegrees(), 8,
                                                Field.BallHieght.LOW, Tag8Pose));
                                ReefFaces.put(6, new ReefFace(Tag6Pose.getRotation().getDegrees(), 6,
                                                Field.BallHieght.LOW,Tag6Pose));
                                ReefTags.add(10);
                                ReefTags.add(7);
                                ReefTags.add(11);
                                ReefTags.add(9);
                                ReefTags.add(8);
                                ReefTags.add(6);
                        }
                }
        }

        public static boolean isReefTag(int TagID) {
                if (wasFieldSet) {
                        return ReefTags.contains(TagID);
                } else {
                        return false;
                }
        }

        public static ReefFace getFaceByID(int TagID) {
                if (wasFieldSet) {
                        return ReefFaces.get(TagID);
                }

                return blankFace;
        }

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
                return Math.sqrt(Math.pow(pose1.getX() - pose2.getX(), 2) + Math.pow(pose1.getY() - pose2.getY(), 2));
        }

}