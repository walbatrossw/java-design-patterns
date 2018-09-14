package practice.after2;

public class Client {
    public static void main(String[] args) {
        Display road = new RoadDisplay();
        road.draw(); // 기본도로 표시

        Display roadWithLane = new LaneDecorator(new RoadDisplay());
        roadWithLane.draw(); // 기본도로 + 차선 표시

        Display roadWithTraffic = new TrafficDecorator(new RoadDisplay());
        roadWithTraffic.draw(); // 기본 도로 + 교통량 표시
    }
}
