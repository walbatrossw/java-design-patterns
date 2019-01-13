package practice.after4_factory;

import java.util.ArrayList;
import java.util.List;

public abstract class ElevatorManager {

    private List<ElevatorController> controllers;

    // 주어진 수만큼 ElevatorController를 생성
    public ElevatorManager(int controllerCount) {

        controllers = new ArrayList<>(controllerCount);

        for (int i = 0; i < controllerCount; i++) {
            ElevatorController elevatorController = new ElevatorController(i + 1);
            controllers.add(elevatorController);
        }

    }

    protected abstract ElevatorScheduler getScheduler();  // primitive or hook method

    // 엘리베이터 요청
    void requestElevator(int destination, Direction direction) {

        // 하위 클래스에서 오버라이드된 getScheduler를 호출
        ElevatorScheduler scheduler = getScheduler();
        int selectedElevator = scheduler.selectElevator(this, destination, direction);
        controllers.get(selectedElevator).gotoFloor(destination);

    }

}
