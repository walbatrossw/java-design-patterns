package practice.after3_singleton;

public class ResponseTimeScheduler implements ElevatorScheduler {

    private static ElevatorScheduler scheduler;
    private ResponseTimeScheduler() {

    }

    public static ElevatorScheduler getInstance() {
        if (scheduler == null) {
            scheduler = new ResponseTimeScheduler();
        }
        return scheduler;
    }

    @Override
    public int selectElevator(ElevatorManager elevatorManager, int destination, Direction direction) {
        return 1;
    }
}
