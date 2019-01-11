package practice.after1;


public class Client {
    public static void main(String[] args) {

        Door door = new Door();

        HyundaiMotor hyundaiMotor = new HyundaiMotor(door);
        hyundaiMotor.move(Direction.DOWN);

        LGMotor lgMotor = new LGMotor(door);
        lgMotor.move(Direction.UP);

    }
}
