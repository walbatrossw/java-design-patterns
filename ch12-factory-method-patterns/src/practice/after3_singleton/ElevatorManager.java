package practice.after3_singleton;

import java.util.ArrayList;
import java.util.List;

public class ElevatorManager {

    private List<ElevatorController> controllers;
    private SchedulerStrategyID strategyID;

    // 주어진 수만큼 ElevatorController를 생성
    public ElevatorManager(int controllerCount, SchedulerStrategyID strategyID) {

        controllers = new ArrayList<>(controllerCount);

        for (int i = 0; i < controllerCount; i++) {
            ElevatorController elevatorController = new ElevatorController(i+1);
            controllers.add(elevatorController);
        }

        this.strategyID = strategyID;

    }

    public void setStrategyID(SchedulerStrategyID strategyID) {
        this.strategyID = strategyID;
    }

    // 엘리베이터 요청
    void requestElevator(int destination, Direction direction) {

        // 주어진 전략 ID에 해당되는 ElevatorScheduler 사용
        ElevatorScheduler scheduler = SchedulerFactory.getScheduler(strategyID);
        System.out.println(scheduler);

        int selectedElevator = scheduler.selectElevator(this, destination, direction);
        controllers.get(selectedElevator).gotoFloor(destination);

    }

}
