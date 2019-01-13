package practice.after2_factory;

// 엘리베이터 컨트롤러
public class ElevatorController {

    private int id;         // 엘라배이터 아이디
    private int curFloor;   // 현재 층

    // 생성자
    public ElevatorController(int id) {
        this.id = id;
        this.curFloor = 1;
    }

    // 목적지로 이동
    public void gotoFloor(int destination) {
        System.out.println("Selected Elevator [" + id + "], Floor : " + curFloor);
        curFloor = destination;
        System.out.println(" ==> " + curFloor);
    }
}
