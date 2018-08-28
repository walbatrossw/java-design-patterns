package practice.commandpatternlamponoff;

// 램프 켜기 커맨드 클래스 : 커맨드 인터페이스 구현
public class LampOnCommand implements Command {

    // 램프 참조 객체 변수
    private Lamp theLamp;

    // 생성자
    public LampOnCommand(Lamp theLamp) {
        this.theLamp = theLamp;
    }

    // 실행 메서드 구현 : 램프 켜기 메서드 호출
    @Override
    public void execute() {
        theLamp.turnOn();
    }

}
