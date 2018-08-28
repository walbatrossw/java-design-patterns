package practice.commandpatternlamponoff;

// 램프 끄기 커맨드 클래스 : 커맨드 인터페이스 구현
public class LampOffCommand implements Command {

    // 램프 참조 객체 변수
    private Lamp theLamp;

    // 생성자
    public LampOffCommand(Lamp theLamp) {
        this.theLamp = theLamp;
    }

    // 실행 메서드 구현 : 램프 끄기 메서드 호출
    @Override
    public void execute() {
        theLamp.turnOff();
    }

}
