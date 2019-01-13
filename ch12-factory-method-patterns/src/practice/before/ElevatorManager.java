package practice.before;

import com.sun.javafx.scene.traversal.Direction;

import java.util.ArrayList;
import java.util.List;

public class ElevatorManager {

    private List<ElevatorController> controllers;
    private ThroughputScheduler scheduler;

    // 주어진 수만큼 ElevatorController를 생성
    public ElevatorManager(int controllerCount) {

        controllers = new ArrayList<>(controllerCount);

        for (int i = 0; i < controllerCount; i++) {
            ElevatorController elevatorController = new ElevatorController(i);
            controllers.add(elevatorController);
        }
        scheduler = new ThroughputScheduler();  // ThroughputScheduler 객체 생성

    }

    // 엘리베이터 요청
    void requestElevator(int destination, Direction direction) {
        // 엘리베이터 선택
        int selectedElevator = scheduler.selectElevator(this, destination, direction);
        // 선택된 엘리베이터 이동
        controllers.get(selectedElevator).gotoFloor(destination);
    }

}
