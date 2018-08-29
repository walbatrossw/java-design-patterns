package exercise.ex01.ex01_2;

import exercise.ex01.TV;
import exercise.ex01.TwoButtonController;

public class Client {

    public static void main(String[] args) {
        TV tv = new TV();
        TwoButtonController rc = new TwoButtonController(tv);

        rc.button1Pressed();
        rc.button2Pressed();

        rc.button1Pressed();
        rc.button2Pressed();

    }

}
