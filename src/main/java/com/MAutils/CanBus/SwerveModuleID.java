
package com.MAutils.CanBus;


public class SwerveModuleID {

    private final CANBusID driveMotor;
    private final CANBusID steerMotor;
    private final CANBusID steerEncoder;

    public SwerveModuleID(CANBusID driveMotor, CANBusID steerMotor, CANBusID steerEncoder) {
        this.driveMotor = driveMotor;
        this.steerMotor = steerMotor;
        this.steerEncoder = steerEncoder;
    }

    public CANBusID getDriveMotor() {
        return driveMotor;
    }

    public CANBusID getSteerMotor() {
        return steerMotor;
    }

    public CANBusID getSteerEncoder() {
        return steerEncoder;
    }

}
