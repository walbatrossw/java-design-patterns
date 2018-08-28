package practice.commandpatternlamponoff;

public class Client {

    public static void main(String[] args) {

        Lamp lamp = new Lamp();
        Command lampOnCommand = new LampOnCommand(lamp);
        Button button = new Button(lampOnCommand);
        button.pressed();

        Command lampOffCommand = new LampOffCommand(lamp);
        button.setCommand(lampOffCommand);
        button.pressed();

    }

}
