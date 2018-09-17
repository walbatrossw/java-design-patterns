package practice.after2;

public class Client3 {
    public static void main(String[] args) {
        Display roadWithCrossingAndLaneAndTraffic = new LaneDecorator(new TrafficDecorator(new CrossingDecorator(new RoadDisplay())));
        roadWithCrossingAndLaneAndTraffic.draw();
    }

}
