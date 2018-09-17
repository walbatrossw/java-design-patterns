package practice.after2;

public class Client2 {
    public static void main(String[] args) {
        Display roadWithLaneAndTraffic = new TrafficDecorator(new LaneDecorator(new RoadDisplay()));
        roadWithLaneAndTraffic.draw();
    }
}
