package practice.commandpatternbutton;

// 버튼 클래스
public class Button {

    private Command theCommand; // 커맨드 인터페이스 참조변수

    // 생성자
    public Button(Command theCommand) {
        setCommand(theCommand);
    }

    // 커맨드 인터페이스 set메서드
    public void setCommand(Command newCommand) {
        this.theCommand = newCommand;
    }

    // 버튼 메서드 : 커맨드 인터페이스의 execute메서드 호출
    public void pressed() {
        theCommand.execute();
    }

}
