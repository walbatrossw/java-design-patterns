package exercise.ex01.ex8_ex9;

public class Client {
    public static void main(String[] args) {
        Battery battery = new Battery();
        Observer display = new BatteryLevelDisplay(battery);
        Observer warning = new LowBatteryWarning(battery);

        battery.attach(display);
        battery.attach(warning);

        battery.consume(20);
        battery.consume(50);
        battery.consume(30);
    }
}
