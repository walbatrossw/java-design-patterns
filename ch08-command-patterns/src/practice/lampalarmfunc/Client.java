package practice.lampalarmfunc;

// 클라이언트 클래스
public class Client {

    public static void main(String[] args) {

        Lamp lamp = new Lamp();                     // 램프 객체 생성
        Alarm alarm = new Alarm();                  // 알람 객체 생성
        Button button = new Button(lamp, alarm);    // 버튼 객체 생성, 램프, 알람 객체 주입

        button.setMode(Mode.LAMP);                  // 램프 모드 변경
        button.pressed();                           // 버튼 누르기

        button.setMode(Mode.ALARM);                 // 알람 모드 변경
        button.pressed();                           // 버튼 누르기

    }

}
