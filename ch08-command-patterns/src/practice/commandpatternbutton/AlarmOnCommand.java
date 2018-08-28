package practice.commandpatternbutton;

// 알람 커맨드 클래스 : 커맨드 인터페이스 구현
public class AlarmOnCommand implements Command {

    // 알람 클래스 참조변수
    private Alarm theAlarm;

    // 생성자
    public AlarmOnCommand(Alarm theAlarm) {
        this.theAlarm = theAlarm;
    }

    // 기능 실행 메서드 구현 : 알람 울림
    @Override
    public void execute() {
        theAlarm.start();
    }

}
