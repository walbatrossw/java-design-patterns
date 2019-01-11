package practice.before;

public class LGMotor {

    private Door door;
    private MotorStatus motorStatus;

    // 생성자
    public LGMotor(Door door) {
        this.door = door;
        this.motorStatus = MotorStatus.STOPPED;
    }

    private void moveLGMotor(Direction direction) {
        // LG 모터 구동
        System.out.println("LG 모터 구동 방향 : " +  direction);
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

        // 이동중이면 메서드 종료
        if (motorStatus == MotorStatus.MOVING) {
            return;
        }

        DoorStatus doorStatus = this.door.getDoorStatus();

        // 문이 열려있으면 문을 닫음
        if (doorStatus == DoorStatus.OPENED) {
            door.close();
        }

        moveLGMotor(direction); // 모터를 주어진 방향으로 작동
        setMotorStatus(MotorStatus.MOVING); // 모터 상태를 이동중으로 변경

    }
}
