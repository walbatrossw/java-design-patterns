package practice.after1;

public class Client {

    public static void main(String[] args) {

        RoadDisplay road = new RoadDisplay();
        road.draw();    // 기본 도로 표시

        RoadDisplay roadWithLane = new RoadDisplayWithLane();
        roadWithLane.draw();    // 기본도로 + 차선 표시

        RoadDisplay roadWithTraffic = new RoadDisplayWithTraffic();
        roadWithTraffic.draw(); // 기본도로 + 교통량 표시

    }

}
