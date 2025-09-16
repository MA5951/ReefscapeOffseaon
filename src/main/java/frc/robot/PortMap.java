
package frc.robot;

import com.MAutils.CanBus.CANBusID;
import com.MAutils.CanBus.SwerveModuleID;
import com.ctre.phoenix6.CANBus;

public class PortMap {

    public static class CANBUS {
        public static final CANBus RIO_BUS = new CANBus("rio");
        public static final CANBus CANivor_BUS = new CANBus("*");

    }

    public static class ElevatorPorts {
        public static final CANBusID MASTER_ELEVATOR_MOTOR = new CANBusID(12, CANBUS.CANivor_BUS);
        public static final CANBusID SLAVE_ELEVATOR_MOTOR = new CANBusID(13, CANBUS.CANivor_BUS);
    }

    public static class ArmPorts {
        public static final CANBusID ARM_MOTOR = new CANBusID(14, CANBUS.RIO_BUS);
    }

    public static class IntakePorts {
        public static final CANBusID INTAKE_MOTOR = new CANBusID(15, CANBUS.RIO_BUS);
        

        public static final int FRONT_SENSOR = 1;
        public static final int REAR_SENSOR = 2;
    }

    public static class ClimbPorts {
        public static final CANBusID MASTER_CLIMB_MOTOR = new CANBusID(16, CANBUS.CANivor_BUS);
        public static final CANBusID SLAVE_CLIMB_MOTOR = new CANBusID(16, CANBUS.CANivor_BUS);

    }

    public static class SwervePorts {

        private static final CANBusID LEFT_FRONT_ENCODER = new CANBusID(22, CANBUS.CANivor_BUS);
        private static final CANBusID LEFT_FRONT_DRIVE = new CANBusID(8, CANBUS.CANivor_BUS);
        private static final CANBusID LEFT_FRONT_TURNING = new CANBusID(5, CANBUS.CANivor_BUS);

        private static final CANBusID LEFT_BACK_ENCODER = new CANBusID(21, CANBUS.CANivor_BUS);
        private static final CANBusID LEFT_BACK_DRIVE = new CANBusID(4, CANBUS.CANivor_BUS);
        private static final CANBusID LEFT_BACK_TURNING = new CANBusID(9, CANBUS.CANivor_BUS);

        private static final CANBusID RIGHT_FRONT_ENCODER = new CANBusID(23, CANBUS.CANivor_BUS);
        private static final CANBusID RIGHT_FRONT_DRIVE = new CANBusID(7, CANBUS.CANivor_BUS);
        private static final CANBusID RIGHT_FRONT_TURNING = new CANBusID(6, CANBUS.CANivor_BUS);

        private static final CANBusID RIGHT_BACK_ENCODER = new CANBusID(24, CANBUS.CANivor_BUS);
        private static final CANBusID RIGHT_BACK_DRIVE = new CANBusID(2, CANBUS.CANivor_BUS);
        private static final CANBusID RIGHT_BACK_TURNING = new CANBusID(3, CANBUS.CANivor_BUS);

        public static final CANBusID PIGEON2 = new CANBusID(12, CANBUS.CANivor_BUS);

        public static final SwerveModuleID[] SWERVE_MODULE_IDS = {
                new SwerveModuleID(LEFT_FRONT_ENCODER, LEFT_FRONT_DRIVE, LEFT_FRONT_TURNING),
                new SwerveModuleID(LEFT_BACK_ENCODER, LEFT_BACK_DRIVE, LEFT_BACK_TURNING),
                new SwerveModuleID(RIGHT_FRONT_ENCODER, RIGHT_FRONT_DRIVE, RIGHT_FRONT_TURNING),
                new SwerveModuleID(RIGHT_BACK_ENCODER, RIGHT_BACK_DRIVE, RIGHT_BACK_TURNING)
        };

    }
}
