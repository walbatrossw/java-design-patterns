package practice.commandpatternlamponoff;

public class Button {

    private Command theCommand;

    public Button(Command theCommand) {
        setCommand(theCommand);
    }

    public void setCommand(Command newCommand) {
        this.theCommand = newCommand;
    }

    public void pressed() {
        theCommand.execute();
    }



}
