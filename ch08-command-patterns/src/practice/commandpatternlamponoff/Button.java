package practice.commandpatternlamponoff;

// 버튼 클래스
public class Button {

    // 커맨드 인터페이스 참조 객체 변수
    private Command theCommand;

    // 생성자
    public Button(Command theCommand) {
        setCommand(theCommand);
    }

    // 커맨드 인터페이스 설정
    public void setCommand(Command newCommand) {
        this.theCommand = newCommand;
    }

    // 버튼 눌림 인지 메서드
    public void pressed() {
        theCommand.execute();
    }



}
