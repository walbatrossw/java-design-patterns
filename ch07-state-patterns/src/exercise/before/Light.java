package exercise.before;

// 형광등 클래스
public class Light {

    private static int ON = 0;  // 형광등 켜짐
    private static int OFF = 1; // 형광등 꺼짐
    private int state;          // 형광등 현재 상태

    // 생성자 : 초기상태는 꺼짐
    public Light() {
        state = OFF;
    }

    public void on_button_pushed() {
        if (state == ON) {
            System.out.println("반응 없음");
        } else {
            // 형광등이 꺼져 있을 때 On버튼을 누르면 켜진상태로 전환
            System.out.println("Light On!");
            state = ON;
        }
    }

    public void off_button_pushed() {
        if (state == OFF) {
            System.out.println("반응 없음");
        } else {
            // 형광등이 켜져 있을 때 Off버튼을 누르면 꺼진상태로 전환
            System.out.println("Light Off!");
            state = OFF;
        }
    }

}
