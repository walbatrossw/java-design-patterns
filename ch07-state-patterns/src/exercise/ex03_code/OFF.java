package exercise.ex03_code;

// 꺼짐 상태 클래스
public class OFF implements LightState {

    // OFF 클래스 인스턴스는 하나만 생성
    private static LightState instance = new OFF();

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
        System.out.println("No Response");
        light.setState(OFF.getInstance());
    }
}
