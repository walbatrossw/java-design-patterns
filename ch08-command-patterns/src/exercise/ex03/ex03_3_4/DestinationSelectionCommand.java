package exercise.ex03.ex03_3_4;

// 엘리베이터 내부에서 버튼을 눌렀을 때 해당 엘리베이터를 지정된 층으로 이동
public class DestinationSelectionCommand implements Command {

    private int destination;                // 목적지 층
    private ElevatorController controller;  // 이동될 엘리베이터에 대한 컨트롤러


    // 생성자
    public DestinationSelectionCommand(int destination, ElevatorController controller) {
        this.destination = destination;
        this.controller = controller;
    }

    // 주어진 ElevatorController의 gotoFloor() 메서드를 호출해 지정된 목적지 층으로 엘리베이터를 이동시킴
    @Override
    public void execute() {
        controller.gotoFloor(destination);
    }

}
