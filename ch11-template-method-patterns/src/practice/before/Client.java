package practice.before;

public class Client {
    public static void main(String[] args) {

        Door door = new Door();
        HyundaiMotor hyundaiMotor = new HyundaiMotor(door);
        hyundaiMotor.move(Direction.UP);

        LGMotor lgMotor = new LGMotor(door);
        lgMotor.move(Direction.DOWN);

    }
}
