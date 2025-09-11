
package frc.robot;

import com.MAutils.CanBus.CANBusID;
import com.ctre.phoenix6.CANBus;

public class PortMap {

    public class CANBUS {
        public static final CANBus RIO_BUS = new CANBus("rio");
        public static final CANBus CANivor_BUS = new CANBus("*");

    }

    public class ElevatorPorts {
        public static final CANBusID MASTER_ELEVATOR_MOTOR = new CANBusID(12, CANBUS.CANivor_BUS);
        public static final CANBusID SLAVE_ELEVATOR_MOTOR = new CANBusID(13, CANBUS.CANivor_BUS);
    }

    public class ArmPorts {
        public static final CANBusID ARM_MOTOR = new CANBusID(14, CANBUS.RIO_BUS);
    }

    public class IntakePorts {
        public static final CANBusID INTAKE_MOTOR = new CANBusID(15, CANBUS.RIO_BUS);

        public static final int FRONT_SENSOR = 1;
        public static final int REAR_SENSOR = 2;
    }

    public class ClimbPorts {
        public static final CANBusID MASTER_CLIMB_MOTOR = new CANBusID(16, CANBUS.CANivor_BUS);
        public static final CANBusID SLAVE_CLIMB_MOTOR = new CANBusID(16, CANBUS.CANivor_BUS);

    }
}
