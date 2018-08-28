package practice.lampalarmfunc;

// 버튼 클래스
public class Button {

    private Lamp theLamp;   // 램프 참조 변수
    private Alarm theAlarm; // 알람 참조 변수
    private Mode theMode;   // 모드 참조 변수

    // 생성자
    public Button(Lamp theLamp, Alarm theAlarm) {
        this.theLamp = theLamp;
        this.theAlarm = theAlarm;
    }

    // 모드 set메서드
    public void setMode(Mode mode) {
        this.theMode = mode;
    }

    // 버튼 누름 메서드 : 모드에 따라 램프, 알람 변경
    public void pressed() {
        switch (theMode) {
            case LAMP:  // 램프 모드면 램프 켜기
                theLamp.turnOn();
                break;
            case ALARM: // 알람 모드면 알람 시작
                theAlarm.start();
                break;
        }
    }
}
