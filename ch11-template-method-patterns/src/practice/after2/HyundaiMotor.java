package practice.after2;

// 현대 모터 클래스 : 모터 클래스 상속
public class HyundaiMotor extends Motor {

    public HyundaiMotor(Door door) {
        super(door);
    }

    // 현대 모터에 맞게 구동 메서드 오버라이드
    @Override
    protected void moveMotor(Direction direction) {
        // 현대 모터 구동
        System.out.println("현대 모터 구동 방향 : " + direction);
    }
}
