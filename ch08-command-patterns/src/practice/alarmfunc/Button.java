package practice.alarmfunc;

// 버튼 클래스
public class Button {

    // 알람 객체 참조
    private Alarm theAlarm;

    // 생성자
    public Button(Alarm theAlarm) {
        this.theAlarm = theAlarm;
    }

    // 버튼이 눌려졌음을 인식하는 메서드
    public void pressed() {
        theAlarm.start();
    }

}
