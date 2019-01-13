package practice.after3_singleton;

// 엘리베이터 스케쥴 인터페이스
public interface ElevatorScheduler {

    // 엘리베이터 선택
    public int selectElevator(ElevatorManager elevatorManager, int destination, Direction direction);

}
