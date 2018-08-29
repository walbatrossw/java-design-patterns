package exercise.ex02.ex02_1;

// 버튼 컨트롤러
public class TwoButtonController {

    // 커맨드 참조변수
    private Command command1;
    private Command command2;

    // 커맨드 참조변수 설정 메서드
    public void setCommand(Command command1, Command command2) {
        this.command1 = command1;
        this.command2 = command2;
    }

    // 첫번째 버튼 누르기 메서드
    public void button1Pressed() {
        command1.execute();
    }

    // 두번째 버튼 누르기 메서드
    public void button2Pressed() {
        command2.execute();
    }

}
