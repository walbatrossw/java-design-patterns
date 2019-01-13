package practice.before;

public class Client {
    public static void main(String[] args) {

        Door door = new Door(); // 문 객체 생성
        HyundaiMotor hyundaiMotor = new HyundaiMotor(door); // 현대 모터 객체 생성
        hyundaiMotor.move(Direction.UP);    // 현대 모터를 위로 구동

        LGMotor lgMotor = new LGMotor(door); // LG 모터 객체 생성
        lgMotor.move(Direction.DOWN);   // LG 모터를 아래로 구동
    }
}
