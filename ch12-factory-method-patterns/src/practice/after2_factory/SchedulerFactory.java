package practice.after2_factory;

import java.util.Calendar;

public class SchedulerFactory {

    public static ElevatorScheduler getScheduler(SchedulerStrategyID strategyID) {
        ElevatorScheduler scheduler = null;

        switch (strategyID) {
            case RESPONSE_TIME:
                scheduler = new ResponseTimeScheduler();
                break;
            case THROUHPUT:
                scheduler = new ThroughputScheduler();
                break;
            case DYNAMIC:
                int hour = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
                if (hour < 12) {
                    scheduler = new ResponseTimeScheduler();
                } else {
                    scheduler = new ThroughputScheduler();
                }
                break;
        }

        return scheduler;
    }

}
