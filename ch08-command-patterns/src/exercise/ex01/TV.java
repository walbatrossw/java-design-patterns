package exercise.ex01;

public class TV {

    private boolean powerOn = false;
    private boolean muteOn = false;

    public void power() {
        powerOn =! powerOn;

        if (powerOn)
            System.out.println("Power On");
        else
            System.out.println("Power Off");

    }

    public void mute() {

        if (!powerOn)
            return;

        muteOn =! muteOn;

        if (muteOn)
            System.out.println("Mute On");
        else
            System.out.println("Mute Off");

    }

}
