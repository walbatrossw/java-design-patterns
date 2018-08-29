package exercise.ex02.ex02_6;

import exercise.ex02.ex02_4.*;

public class Client {

    public static void main(String[] args) {

        TV tv = new TV();                                       // TV 객체 생성
        TwoButtonController rc = new TwoButtonController();     // 컨트롤러 객체 생성
        Command powerCommand = new PowerCommand(tv);            // 파워 커맨드 객체 생성, tv 객체 주입
        Command muteCommand = new MuteCommand(tv);              // 음소거 커맨드 객체 생성, tv 객체 주입

        rc.setCommand(muteCommand, powerCommand);               // button1에는 음소거, button2에는 전원 객체를 각각 설정

        rc.button1Pressed();    // 전원이 켜지지 않았기 때문에 반응 없음
        rc.button2Pressed();    // 전원 켜짐 : Power On
        rc.button1Pressed();    // 음소거  : Mute On
        rc.button1Pressed();    // 음소거 해제 : Mute Off
        rc.button2Pressed();    // 전원 꺼짐 : Power Off
        rc.button1Pressed();    // 전원이 꺼졌기 때문에 반응 없음

    }

}
