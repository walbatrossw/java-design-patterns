package practice.commandpatternlamponoff;

// 클라이언트 클래스
public class Client {

    public static void main(String[] args) {

        Lamp lamp = new Lamp();                                 // 램프 객체 생성
        Command lampOnCommand = new LampOnCommand(lamp);        // 커맨드 인터페이스를 구현한 클래스 객체 생성 : 램프 켜기
        Button button = new Button(lampOnCommand);              // 버튼 객체 생성 : 램프 커맨드 객체 주입
        button.pressed();                                       // 버튼 누르기 : 램프 켜짐

        Command lampOffCommand = new LampOffCommand(lamp);      // 커맨드 인터페이스를 구현한 클래스 객체 생성 : 램프 끄기
        button.setCommand(lampOffCommand);                      // 버튼 객체 설정 : 램프 끄기
        button.pressed();                                       // 버튼 누르기 : 램프 꺼짐

    }

}
