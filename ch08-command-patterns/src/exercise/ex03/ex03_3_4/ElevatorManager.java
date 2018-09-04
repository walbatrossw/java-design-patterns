package exercise.ex03.ex03_3_4;

import com.sun.javafx.scene.traversal.Direction;

import java.util.ArrayList;
import java.util.List;

// 복수의 엘리베이터를 관리하는 클래스
public class ElevatorManager {

    private List<ElevatorController> controllers;

    // 생성자
    public ElevatorManager(int controllerCount) {
        controllers = new ArrayList<>(controllerCount);
    }

    // 엘리베이터 객체 추가
    public void addController(ElevatorController controller) {
        controllers.add(controller);
    }

    // 엘리베이터 요청
    public void requestElevator(int destination, Direction direction) {
        int selectedElevator = selectElevator(destination, direction);  // 엘리베이터 선택
        controllers.get(selectedElevator).gotoFloor(destination);       // 선택된 엘리베이터를 목적지 층으로 이동
    }

    // 목적지 층과 요청방향에 따라 엘리베이터를 선택
    private int selectElevator(int destinaton, Direction direction) {
        return 0;
        // 엘리베이터 선택, 현재는 첫번째 엘리베이터 선택
    }

}
