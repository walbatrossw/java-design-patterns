package practice.after1_starategy;

// 클라이언트
public class Client {
    public static void main(String[] args) {
        ElevatorManager elevatorManager = new ElevatorManager(10);
        elevatorManager.requestElevator(10, Direction.UP);
    }
}
