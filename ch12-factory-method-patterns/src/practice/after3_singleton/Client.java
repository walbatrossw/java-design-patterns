package practice.after3_singleton;

// 클라이언트
public class Client {
    public static void main(String[] args) {

        ElevatorManager managerWithResponseTimeScheduler = new ElevatorManager(2, SchedulerStrategyID.RESPONSE_TIME);
        managerWithResponseTimeScheduler.requestElevator(10, Direction.UP);

        ElevatorManager managerWithThroughputScheduler = new ElevatorManager(2, SchedulerStrategyID.THROUHPUT);
        managerWithThroughputScheduler.requestElevator(10, Direction.UP);

        ElevatorManager managerWithDynamicScheduler = new ElevatorManager(2, SchedulerStrategyID.DYNAMIC);
        managerWithDynamicScheduler.requestElevator(10, Direction.UP);

    }
}
