package practice.after2;

import com.sun.javafx.scene.traversal.Direction;

public class LGMotor extends Motor {

    public LGMotor(Door door) {
        super(door);
    }

    @Override
    protected void moveMotor(Direction direction) {
        // LG 모터 구동
        System.out.println("LG 모터 구동");
    }
}
