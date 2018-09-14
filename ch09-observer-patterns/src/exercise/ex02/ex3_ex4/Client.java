package exercise.ex02.ex3_ex4;

public class Client {
    public static void main(String[] args) {
        ElevatorController controller = new ElevatorController();
        Observer elevatorDisplay = new ElevatorDisplay(controller);
        Observer floorDisplay = new FloorDisplay(controller);
        Observer voiceNotice = new VoiceNotice(controller);
        Observer controlRoomDisplay = new ControlRoomDisplay(controller);

        controller.attach(elevatorDisplay);
        controller.attach(floorDisplay);
        controller.attach(voiceNotice);
        controller.attach(controlRoomDisplay);

        controller.gotoFloor(5);
        controller.gotoFloor(3);
    }
}
