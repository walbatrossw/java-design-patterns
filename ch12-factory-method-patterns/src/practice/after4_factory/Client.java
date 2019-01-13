package practice.after4_factory;

// 클라이언트
public class Client {
    public static void main(String[] args) {

        ElevatorManager managerWithResponseTimeScheduler = new ElevatorManagerWithResponseTimeScheduling(2);
        managerWithResponseTimeScheduler.requestElevator(10, Direction.UP);

        ElevatorManager managerWithThroughputScheduler = new ElevatorManagerWithThroughputScheduling(2);
        managerWithThroughputScheduler.requestElevator(10, Direction.UP);

        ElevatorManager managerWithDynamicScheduler = new ElevatorManagerWithDynamicScheduling(2);
        managerWithDynamicScheduler.requestElevator(10, Direction.UP);

    }
}
