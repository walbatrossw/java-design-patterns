package practice.after1;

public class HyundaiMotor extends Motor {

    public HyundaiMotor(Door door) {
        super(door);
    }

    private void moveHyundaiMotor(Direction direction) {
        // 현대 모터 구동
        System.out.println("현대 모터 구동 방향 : " + direction);
    }

    public void move(Direction direction) {

        MotorStatus motorStatus = getMotorStatus();

        if (motorStatus == MotorStatus.MOVING) {
            return;
        }

        DoorStatus doorStatus = door.getDoorStatus();

        if (doorStatus == DoorStatus.OPENED) {
            door.close();
        }

        moveHyundaiMotor(direction);
        setMotorStatus(MotorStatus.MOVING);

    }

}
