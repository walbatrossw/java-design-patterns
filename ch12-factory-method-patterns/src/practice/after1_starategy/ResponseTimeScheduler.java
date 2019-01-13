package practice.after1_starategy;

public class ResponseTimeScheduler implements ElevatorScheduler {

    @Override
    public int selectElevator(ElevatorManager elevatorManager, int destination, Direction direction) {
        return 1;
    }
}
