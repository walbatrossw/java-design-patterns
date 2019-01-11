package practice.after2;

// 문 클래스
public class Door {

    // 문 상태 변수
    private DoorStatus doorStatus;

    // 생성자
    public Door() {
        this.doorStatus = DoorStatus.CLOSED;
    }

    public DoorStatus getDoorStatus() {
        return doorStatus;
    }

    // 닫기
    public void close() {
        doorStatus = DoorStatus.CLOSED;
    }

    // 열기
    public void open() {
        doorStatus = DoorStatus.OPENED;
    }

}
