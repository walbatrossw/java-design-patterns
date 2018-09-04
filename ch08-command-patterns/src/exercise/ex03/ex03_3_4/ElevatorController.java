package exercise.ex03.ex03_3_4;

// 엘리베이터 하나를 이동시키는 클래스
public class ElevatorController {

    private int id;         // 엘리베이터 식별자
    private int curFloor;   // 엘리베이터의 현재 층

    // 생성자
    public ElevatorController(int id) {
        this.id = id;
    }

    // 주어진 층으로 엘리베이터 이동
    public void gotoFloor(int destination) {
        curFloor = destination;
        System.out.println("Elevator [ " + id + " ]  Current Floor : " + curFloor);
    }

}
