package exercise.ex03_code;

// 수면모드 상태 클래스
public class SLEEPING implements LightState {

    // SLEEPING 클래스 인스턴스는 하나만 생성
    private static LightState instance = new SLEEPING();

    public static LightState getInstance() {
        return instance;
    }

    @Override
    public void on_button_pushed(Light light) {
        System.out.println("Light On!!!");
        light.setState(ON.getInstance());
    }

    @Override
    public void off_button_pushed(Light light) {
        System.out.println("Light Off!!!");
        light.setState(OFF.getInstance());
    }
}
