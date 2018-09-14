package exercise.ex01.ex8_ex9;

public class LowBatteryWarning implements Observer {

    private static final int LOW_BATTERY = 30;
    private Battery battery;

    public LowBatteryWarning(Battery battery) {
        this.battery = battery;
    }

    @Override
    public void update() {
        int level = battery.getLevel();
        // 배터리 잔량이 LOW_BATTERY(30)보다 작으면 경고 메시지 출력
        if (level < LOW_BATTERY) {
            System.out.println("<WARNING> LOW BATTERY " + level + "Compared with " + LOW_BATTERY );
        }
    }
}
