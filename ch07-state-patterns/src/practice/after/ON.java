package practice.after;

public class ON implements State {

    private static ON on = new ON();

    public ON() {

    }

    public static ON getInstance() {
        return on;
    }

    @Override
    public void on_button_pushed(Light light) {
        System.out.println("반응 없음");
    }

    @Override
    public void off_button_pushed(Light light) {
        light.setState(OFF.getInstance());
        System.out.println("Light off");
    }
}
