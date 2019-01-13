package practice.before;

public class Client {
    public static void main(String[] args) {
        ElevatorManager elevatorManager = new ElevatorManager(10);
        elevatorManager.requestElevator(10, Direction.UP);
    }
}
