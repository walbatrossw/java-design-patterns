package practice.after2_factory;

public class ResponseTimeScheduler implements ElevatorScheduler {

    @Override
    public int selectElevator(ElevatorManager elevatorManager, int destination, Direction direction) {
        return 1;
    }
}
