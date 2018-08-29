package exercise.ex02.ex02_5;

import exercise.ex02.ex02_4.*;

public class Client {
    public static void main(String[] args) {

        TV tv = new TV();                                           // TV 객체 생성
        TwoButtonController rc = new TwoButtonController();         // 컨트롤러 객체 생성

        Command powerCommand = new PowerCommand(tv);                // 파워 커맨드 객체 생성, tv 주입
        rc.setCommand(powerCommand, powerCommand);                  // 컨트롤러에 파워 커맨드 객체 설정
        rc.button1Pressed();                                        // button1 : 켜짐
        rc.button2Pressed();                                        // button2 : 꺼짐
        rc.button1Pressed();                                        // button1 : 켜짐
        rc.button1Pressed();                                        // button1 : 꺼짐
        rc.button2Pressed();                                        // button2 : 켜짐
        rc.button1Pressed();                                        // button1 : 꺼짐

    }
}
