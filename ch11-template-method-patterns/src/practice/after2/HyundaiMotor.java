package practice.after2;

import com.sun.javafx.scene.traversal.Direction;

public class HyundaiMotor extends Motor {

    public HyundaiMotor(Door door) {
        super(door);
    }

    @Override
    protected void moveMotor(Direction direction) {
        // 현대 모터 구동
        System.out.println("현대 모터 구동");
    }
}
