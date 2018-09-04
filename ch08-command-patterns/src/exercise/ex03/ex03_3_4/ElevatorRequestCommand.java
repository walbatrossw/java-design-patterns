package exercise.ex03.ex03_3_4;

import com.sun.javafx.scene.traversal.Direction;

// 건물의 층에서 버튼을 눌렀을 때 여러 엘리베이터 중에서 적절한 엘리베이터를 해당 층으로 이동시킴
public class ElevatorRequestCommand implements Command {

    private ElevatorManager elevatorManager;    // 적절한 엘리베이터를 이동시킬 때 필요한 elevatorManager
    private int destination;        // 목적지 층, 버튼이 눌린 충
    private Direction direction;    // 요청 방향, 위로 or 아래로

    // 생성자
    public ElevatorRequestCommand(ElevatorManager elevatorManager, int destination, Direction direction) {
        this.elevatorManager = elevatorManager;
        this.destination = destination;
        this.direction = direction;
    }

    // 주어진 elevatorManager의 requestElevator()메서드 호출해 목적지 층과 요청방향에 따라 적절한 엘리베이터를 이동
    @Override
    public void execute() {
        elevatorManager.requestElevator(destination, direction);
    }
}
