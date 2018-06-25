package exercise.ex04_code;

import java.util.Random;

public class Printer {

    private boolean available = true;

    public boolean isAvailable() {
        return available;
    }

    public void print(String name) {
        try {
            Thread.sleep(new Random().nextInt());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

}
