package exercise.ex03_code;

// 형광등 state 인터페이스
public interface LightState {

    // 켜짐 메서드
    public void on_button_pushed(Light light);

    // 꺼짐 메서드
    public void off_button_pushed(Light light);

}
