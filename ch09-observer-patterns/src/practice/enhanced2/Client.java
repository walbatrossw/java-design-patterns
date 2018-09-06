package practice.enhanced2;

public class Client {
    public static void main(String[] args) {

        ScoreRecord scoreRecord = new ScoreRecord();
        DataSheetView dataSheetView3 = new DataSheetView(scoreRecord, 3);
        scoreRecord.attach(dataSheetView3);
        MinMaxView minMaxView = new MinMaxView(scoreRecord);
        scoreRecord.attach(minMaxView);

        for (int i = 1; i <= 5; i++) {
            int score = i * 10;
            System.out.println("adding " + score);
            scoreRecord.addScore(score);
        }

        scoreRecord.detach(dataSheetView3);
        StatisticsView statisticsView = new StatisticsView(scoreRecord);
        scoreRecord.attach(statisticsView);

        for (int i = 1; i <= 5; i++) {
            int score = i * 10;
            System.out.println("adding " + score);
            scoreRecord.addScore(score);
        }
    }
}
