package exercise.ex02.ex02_4;

public class TwoButtonController {

    private Command command1;
    private Command command2;

    public void setCommand(Command command1, Command command2) {
        this.command1 = command1;
        this.command2 = command2;
    }

    public void button1Pressed() {
        command1.execute();
    }

    public void button2Pressed() {
        command2.execute();
    }

}
