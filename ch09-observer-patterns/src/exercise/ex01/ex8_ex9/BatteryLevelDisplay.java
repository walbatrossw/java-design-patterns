package exercise.ex01.ex8_ex9;

public class BatteryLevelDisplay implements Observer {

    private Battery battery;

    public BatteryLevelDisplay(Battery battery) {
        this.battery = battery;
    }

    // 변경관리 대상이 되는 데이터, 즉 Battery 클래스 변경시 호출되는 메서드
    @Override
    public void update() {
        int level = battery.getLevel();
        System.out.println("Level : " + level); // 배터리 잔량 표시
    }

}
