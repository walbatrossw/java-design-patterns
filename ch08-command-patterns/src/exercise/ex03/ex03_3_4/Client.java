package exercise.ex03.ex03_3_4;

import com.sun.javafx.scene.traversal.Direction;

public class Client {
    public static void main(String[] args) {
        ElevatorController controller1 = new ElevatorController(1);
        ElevatorController controller2 = new ElevatorController(2);

        ElevatorManager manager = new ElevatorManager(2);
        manager.addController(controller1);
        manager.addController(controller2);

        Command destinationCommand1stController = new DestinationSelectionCommand(1, controller1);
        ElevatorButton destinationButton1stFloor = new ElevatorButton(destinationCommand1stController);
        destinationButton1stFloor.pressed();

        Command destinationCommand2ndController = new DestinationSelectionCommand(2, controller2);
        ElevatorButton destinationButton2ndFloor = new ElevatorButton(destinationCommand2ndController);
        destinationButton2ndFloor.pressed();

        Command requestDownCommand = new ElevatorRequestCommand(manager, 2, Direction.DOWN);
        ElevatorButton requestDownFloorButton2ndFloor = new ElevatorButton(requestDownCommand);
        requestDownFloorButton2ndFloor.pressed();
    }
}
