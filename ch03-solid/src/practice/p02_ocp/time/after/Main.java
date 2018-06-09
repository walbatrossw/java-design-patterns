package practice.p02_ocp.time.after;

public class Main {

    public static void main(String[] args) {
        TimeReminder timeReminder = new TimeReminder();
        TimeProvider timeProvider = new FakeTimeProvider();
        timeProvider.setHours(18);
        timeReminder.setTimeProvider(timeProvider);
    }
}
