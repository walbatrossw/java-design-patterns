package practice.commandpatternbutton;

// 클라이언트 클래스
public class Client {
    public static void main(String[] args) {

        Lamp lamp = new Lamp();                             // 램프 객체 생성
        Command lampOnCommand = new LampOnCommand(lamp);    // 램프 실행 객체 생성
        Button button1 = new Button(lampOnCommand);         // 버튼1 객체 생성
        button1.pressed();                                  // 버튼1 누르기 : 램프 켜짐

        Alarm alarm = new Alarm();                          // 알람 객체 생성
        Command alarmOnCommand = new AlarmOnCommand(alarm); // 알람 실행 객체 생성
        Button button2 = new Button(alarmOnCommand);        // 버튼2 객체 생성
        button2.pressed();                                  // 버튼2 누르기 : 알람 울림

        button2.setCommand(lampOnCommand);                  // 버튼2 : 실행 객체 변경
        button2.pressed();                                  // 버튼2 : 누르기 : 램프 켜짐

    }
}
