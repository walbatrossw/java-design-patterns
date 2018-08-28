package practice.alarmfunc;

public class Client {

    public static void main(String[] args) {

        Alarm alarm = new Alarm();  // 알람 객체 생성
        Button alarmButton = new Button(alarm); // 버튼 객체 생성
        alarmButton.pressed();  // 알람 버튼 누르기

    }

}
