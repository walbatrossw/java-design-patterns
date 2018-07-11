package practice.after;

// OFF 상태 클래스 : State 구현
public class OFF implements State {

    private static OFF off = new OFF();

    private OFF() {

    }

    // 싱글턴 적용
    public static OFF getInstance() {
        return off;
    }

    @Override
    public void on_button_pushed(Light light) {
        System.out.println("Light On");
        light.setState(ON.getInstance());
    }

    @Override
    public void off_button_pushed(Light light) {
        System.out.println("No Response");
    }
}
