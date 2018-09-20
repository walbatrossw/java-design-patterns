package practice.before;

import com.sun.javafx.scene.traversal.Direction;

public class HyundaiMotor {

    private Door door;
    private MotorStatus motorStatus;

    public HyundaiMotor(Door door) {
        this.door = door;
        this.motorStatus = MotorStatus.STOPPED;
    }

    private void moveHyundaiMotor(Direction direction) {
        // Hyundai Motor 구동
    }

    public MotorStatus getMotorStatus() {
        return motorStatus;
    }

    public void setMotorStatus(MotorStatus motorStatus) {
        this.motorStatus = motorStatus;
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
