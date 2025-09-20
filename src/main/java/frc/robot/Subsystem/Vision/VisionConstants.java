
package frc.robot.Subsystem.Vision;

import com.MAutils.Components.CameraTypes;
import com.MAutils.Utils.ConvUtil;
import com.MAutils.Vision.Filters.FiltersConfig;
import com.MAutils.Vision.IOs.AprilTagCamera;
import com.MAutils.Vision.IOs.CameraSimIO;

import edu.wpi.first.math.geometry.Rotation3d;
import edu.wpi.first.math.geometry.Transform3d;
import frc.robot.RobotContainer;
import frc.robot.Subsystem.Swerve.SwerveConstants;

public class VisionConstants {

        // public static final AprilTagCamera frontLeftLimelight = new AprilTagCamera(
        // new LimelightIO("limelight-frontl", () -> new Rotation3d()), new
        // FiltersConfig(), () ->
        // ConvUtil.DegreesToRadians(RobotContainer.swerve.getGyro().getGyroData().yaw));

        public static final AprilTagCamera frontLeftLimelight = new AprilTagCamera(
                        new CameraSimIO("Left", CameraTypes.Cameras.LL4,
                                        new Transform3d(0, 0.1, 0.15,
                                                        new Rotation3d(0, ConvUtil.DegreesToRadians(-25), 0)),
                                        () -> SwerveConstants.SWERVE_CONSTANTS.SWERVE_DRIVE_SIMULATION
                                                        .getSimulatedDriveTrainPose()),
                        new FiltersConfig(),
                        () -> ConvUtil.DegreesToRadians(RobotContainer.swerve.getGyro().getGyroData().yaw));

        public static final AprilTagCamera fronRightLimelight = new AprilTagCamera(
                        new CameraSimIO("Right", CameraTypes.Cameras.LL4,
                                        new Transform3d(0, -0.1, 0.15,
                                                        new Rotation3d(0, ConvUtil.DegreesToRadians(-25), 0)),
                                        () -> SwerveConstants.SWERVE_CONSTANTS.SWERVE_DRIVE_SIMULATION
                                                        .getSimulatedDriveTrainPose()),
                        new FiltersConfig(),
                        () -> ConvUtil.DegreesToRadians(RobotContainer.swerve.getGyro().getGyroData().yaw));

}