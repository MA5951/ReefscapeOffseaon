
package frc.robot.Subsystem.Vision;

import com.MAutils.Vision.VisionSystem;

import edu.wpi.first.math.geometry.Pose2d;
import edu.wpi.first.math.geometry.Rotation2d;

public class Vision {
    private static Vision vison;

    private Vision() {
        VisionSystem.getInstance()
                .setCameras(VisionConstants.frontLeftLimelight, VisionConstants.fronRightLimelight);
    }

    public Pose2d getLeftPose2d() {
        return new Pose2d(VisionConstants.frontLeftLimelight.getCameraIO().getTag().txnc,
                VisionConstants.frontLeftLimelight.getCameraIO().getTag().tync, new Rotation2d());
    }

    public Pose2d getRightPose2d() {
        return new Pose2d(VisionConstants.fronRightLimelight.getCameraIO().getTag().txnc,
                VisionConstants.fronRightLimelight.getCameraIO().getTag().tync, new Rotation2d());
    }


    public static final Vision getInstantce() {
        if (vison == null) {
            vison = new Vision();
        }
        return vison;
    }

}