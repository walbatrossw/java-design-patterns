package exercise.ex03_code;

// 형광등 Context 클래스
public class Light {

    private LightState state = OFF.getInstance();   // 형광등 초기 상태 off

    // 현재 상태 설정
    public void setState(LightState state) {
        this.state = state;
    }

    // on 버튼을 누를 때 마다 상태 변환 : ON or Sleeping
    public void on_button_pushed() {
        state.on_button_pushed(this);
    }

    // off 버튼을 누를 때 마다 상태 변환 : OFF
    public void off_button_pushed() {
        state.off_button_pushed(this);
    }

}
