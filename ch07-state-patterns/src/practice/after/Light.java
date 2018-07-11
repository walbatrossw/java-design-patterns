package practice.after;

// 형광등 클래스
public class Light {

    private State state;

    // 생성자 : 형광등은 항상 꺼진 상태로 초기화
    public Light() {
        state = OFF.getInstance();
    }

    public void setState(State state) {
        this.state = state;
    }

    // 켜짐 작업 위임
    public void on_button_pushed() {
        state.on_button_pushed(this);
    }

    // 꺼짐 작업 위임
    public void off_button_pushed() {
        state.off_button_pushed(this);
    }

}
