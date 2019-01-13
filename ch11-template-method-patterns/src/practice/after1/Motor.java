package practice.after1;

// HyundaiMotor, LGMotor 공통적인 기능을 구현하는 클래스
public abstract class Motor {

    protected Door door;                // 문
    private MotorStatus motorStatus;    // 모터 상태 변수

    // 생성자
    public Motor(Door door) {
        this.door = door;
        this.motorStatus = MotorStatus.STOPPED;
    }

    public MotorStatus getMotorStatus() {
        return motorStatus;
    }

    public void setMotorStatus(MotorStatus motorStatus) {
        this.motorStatus = motorStatus;
    }

}
