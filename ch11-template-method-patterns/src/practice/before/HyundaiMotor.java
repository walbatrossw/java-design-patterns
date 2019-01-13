package practice.before;

// 현대 모터 클래스
public class HyundaiMotor {

    private Door door;                  // 문
    private MotorStatus motorStatus;    // 모터 상태 변수

    // 생성자
    public HyundaiMotor(Door door) {
        this.door = door;
        this.motorStatus = MotorStatus.STOPPED;
    }

    // 현대 모터 구동
    private void moveHyundaiMotor(Direction direction) {
        // 현대 모터 구동
        System.out.println("현대 모터 구동 방향 : " + direction);
    }

    public MotorStatus getMotorStatus() {
        return motorStatus;
    }

    public void setMotorStatus(MotorStatus motorStatus) {
        this.motorStatus = motorStatus;
    }

    // 이동
    public void move(Direction direction) {

        MotorStatus motorStatus = getMotorStatus();

        // 모터가 구동 중이면 메서드 종료
        if (motorStatus == MotorStatus.MOVING) {
            return;
        }

        DoorStatus doorStatus = this.door.getDoorStatus();

        // 문이 열려있으면 문을 닫음
        if (doorStatus == DoorStatus.OPENED) {
            door.close();
        }

        moveHyundaiMotor(direction);        // 모터를 주어진 방향으로 작동
        setMotorStatus(MotorStatus.MOVING); // 모터 상태를 이동중으로 변경
    }

}
