
package com.MAutils.Vision.Util;

import edu.wpi.first.math.geometry.Transform3d;

public class VisionUtil {


    public static Double getDistance(Transform3d robotToCamera, double tagHieght, double tagPitch) {
        return (tagHieght - robotToCamera.getZ()) / Math.tan(Math.toRadians(robotToCamera.getRotation().getY() + tagPitch));
    }

}
