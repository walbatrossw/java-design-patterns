package practice.commandpatternbutton;

// 램프 커맨드 클래스 : 커맨드 인터페이스 구현
public class LampOnCommand implements Command {

    // 램프 클래스 참조변수
    private Lamp theLamp;

    // 생성자
    public LampOnCommand(Lamp theLamp) {
        this.theLamp = theLamp;
    }

    // 기능 실행 메서드 구현 : 램프 켜기
    @Override
    public void execute() {
        theLamp.turnOn();
    }

}
