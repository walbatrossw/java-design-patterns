package practice.after1_starategy;

import java.util.ArrayList;
import java.util.Calendar;
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
        ElevatorScheduler scheduler;

        // 0 ~ 23
        int hour = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);

        // 오전 : ResponseTimeScheduler 사용
        if (hour <  12) {
            scheduler = new ResponseTimeScheduler();
        } else {    // 오후 : ThroughputScheduler 사용
            scheduler = new ThroughputScheduler();
        }

        int selectElevator = scheduler.selectElevator(this, destination, direction);
        controllers.get(selectElevator).gotoFloor(destination);

    }

}
