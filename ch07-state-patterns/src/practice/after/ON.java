package practice.after;

// ON 상태 클래스 : State 인테페이스 구현
public class ON implements State {

    private static ON on = new ON();

    public ON() {

    }

    // 싱글턴 적용
    public static ON getInstance() {
        return on;
    }

    @Override
    public void on_button_pushed(Light light) {
        System.out.println("No Response");
    }

    @Override
    public void off_button_pushed(Light light) {
        light.setState(OFF.getInstance());
        System.out.println("Light Off");
    }
}
