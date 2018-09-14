package exercise.ex01;

public class Client {
    public static void main(String[] args) {
        Battery battery = new Battery();
        BatteryLevelDisplay display = new BatteryLevelDisplay(battery);
        LowBatteryWarning warning = new LowBatteryWarning(battery);

        battery.setDisplay(display);
        battery.setWarning(warning);

        battery.consume(20);
        battery.consume(50);
        battery.consume(10);
    }
}
