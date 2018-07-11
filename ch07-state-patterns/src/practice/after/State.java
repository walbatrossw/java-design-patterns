package practice.after;

// 상태 인터페이스
public interface State {

    public void on_button_pushed(Light light);
    public void off_button_pushed(Light light);

}
