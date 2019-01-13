package practice.after2;

// LG 모터 클래스 : 모터 클래스 상속
public class LGMotor extends Motor {

    public LGMotor(Door door) {
        super(door);
    }

    // LG 모터에 맞게 구동 메서드 오버라이드
    @Override
    protected void moveMotor(Direction direction) {
        // LG 모터 구동
        System.out.println("LG 모터 구동 방향 : " + direction);
    }
}
