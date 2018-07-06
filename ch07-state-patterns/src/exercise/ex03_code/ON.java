package exercise.ex03_code;

// 켜짐 상태 클래스
public class ON implements LightState {

    // ON 클래스 인스턴스는 하나만 생성
    private static LightState instance = new ON();

    public static LightState getInstance() {
        return instance;
    }

    @Override
    public void on_button_pushed(Light light) {
        System.out.println("Sleeping Mode");
        light.setState(SLEEPING.getInstance());
    }

    @Override
    public void off_button_pushed(Light light) {
        System.out.println("Light off");
        light.setState(OFF.getInstance());
    }
}
