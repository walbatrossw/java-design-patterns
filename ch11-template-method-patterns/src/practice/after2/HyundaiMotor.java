package practice.after2;

public class HyundaiMotor extends Motor {

    public HyundaiMotor(Door door) {
        super(door);
    }

    @Override
    protected void moveMotor(Direction direction) {
        // 현대 모터 구동
        System.out.println("현대 모터 구동 방향 : " + direction);
    }
}
