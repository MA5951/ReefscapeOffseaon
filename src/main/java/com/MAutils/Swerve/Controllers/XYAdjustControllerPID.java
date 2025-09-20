
package com.MAutils.Swerve.Controllers;

import java.util.function.Supplier;

import com.MAutils.Logger.MALog;
import com.MAutils.Swerve.SwerveSystem;
import com.MAutils.Swerve.SwerveSystemConstants;
import com.MAutils.Swerve.Utils.PIDController;
import com.MAutils.Swerve.Utils.SwerveController;
import com.MAutils.Utils.ChassisSpeedsUtil;

import edu.wpi.first.math.geometry.Pose2d;
import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.kinematics.ChassisSpeeds;

public class XYAdjustControllerPID extends SwerveController {

    private PIDController xController;
    private PIDController yController;
    private Supplier<Pose2d> measurmentSupplier;
    private Supplier<Pose2d> setPointSupplier;
    private Supplier<Double> gyroSupplier;
    private boolean fieldRelative = true;
    private double lastTimeRan = 0;
    private Supplier<ChassisSpeeds> speedsSupplier;

    public XYAdjustControllerPID(SwerveSystemConstants swerveSystem, PIDController xController,
    PIDController yController,
            Supplier<Pose2d> measurment) {
        super("XY Adjust Controller");
        this.xController = xController;
        this.yController = yController;
        this.measurmentSupplier = () -> measurment.get();
        withGyroSupplier(() -> SwerveSystem.getInstance(swerveSystem).getGyroData().yaw);
        speedsSupplier = () -> SwerveSystem.getInstance(swerveSystem).getChassisSpeeds();
    }

    public XYAdjustControllerPID withGyroSupplier(Supplier<Double> gyroSupplier) {
        this.gyroSupplier = gyroSupplier;
        return this;
    }

    public XYAdjustControllerPID withFieldRelative(boolean fieldRelative) {
        this.fieldRelative = fieldRelative;

        return this;
    }

    public XYAdjustControllerPID withXYControllers(PIDController xController, PIDController yController) {
        this.xController = xController;
        this.yController = yController;
        return this;
    }

    public XYAdjustControllerPID withXYSetPoint(Supplier<Pose2d> setPoint) {
        this.setPointSupplier = () -> setPoint.get();
        return this;
    }

    public XYAdjustControllerPID withXYSetPoint(Pose2d setPoint) {
        this.setPointSupplier = () -> setPoint;
        return this;
    }

    public XYAdjustControllerPID withMeasurment(Supplier<Pose2d> measurmentSUpplier) {
        measurmentSupplier = measurmentSUpplier;
        return this;
    }

    public void updateSpeeds() {

        speeds.vxMetersPerSecond = xController.calculate(measurmentSupplier.get().getX(),
                setPointSupplier.get().getX());
        speeds.vyMetersPerSecond = yController.calculate(measurmentSupplier.get().getY(),
                setPointSupplier.get().getY());

        if (fieldRelative) {
            speeds = ChassisSpeedsUtil.FromFieldToRobot(speeds,
                    Rotation2d.fromDegrees(gyroSupplier.get()));
        } // TODO: Test Field relativ in all code

    }

    public boolean atSetpoint() {
        return xController.atSetpoint() && yController.atSetpoint();
    }

    public Pose2d getSetPoint() {
        return new Pose2d(xController.getSetpoint(), yController.getSetpoint(), new Rotation2d());
    }

    public void logController() {
        super.logController();

        MALog.log("/Subsystems/Swerve/Controllers/XY Adjust Controller/X Position", measurmentSupplier.get().getX());
        MALog.log("/Subsystems/Swerve/Controllers/XY Adjust Controller/Y Position", measurmentSupplier.get().getY());
        MALog.log("/Subsystems/Swerve/Controllers/XY Adjust Controller/X Set Point", xController.getSetpoint());
        MALog.log("/Subsystems/Swerve/Controllers/XY Adjust Controller/Y Set Point", yController.getSetpoint());
        MALog.log("/Subsystems/Swerve/Controllers/XY Adjust Controller/X At Point", xController.atSetpoint());
        MALog.log("/Subsystems/Swerve/Controllers/XY Adjust Controller/Y At Point", yController.atSetpoint());
    }
}
