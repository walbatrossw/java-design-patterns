package practice.p02_ocp.time.after;

import java.util.Calendar;

public class TimeReminder {

    TimeProvider timeProvider;

    MP3 mp3 = new MP3();

    public void setTimeProvider(TimeProvider timeProvider) {
        this.timeProvider = timeProvider;   // 테스트 스텁이나 시간을 제공하는 인스턴스 주입
    }

    public void reminder() {

        int hours = timeProvider.getTime();

        if (hours >= 22) {
            mp3.playSong();
        }

    }

}

