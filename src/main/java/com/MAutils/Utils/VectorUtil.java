
package com.MAutils.Utils;

import edu.wpi.first.math.geometry.Translation2d;
import edu.wpi.first.math.kinematics.SwerveModuleState;

public class VectorUtil {

    public static Translation2d getVectorFromSwerveState(SwerveModuleState state) {
        return new Translation2d(state.speedMetersPerSecond, state.angle);
    }

    

}
