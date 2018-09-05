package practice.before;

public class Client {
    public static void main(String[] args) {

        ScoreRecord scoreRecord = new ScoreRecord();
        DataSheetView dataSheetView = new DataSheetView(scoreRecord, 3);

        scoreRecord.setDataSheetView(dataSheetView);
        for (int i = 1; i <= 5; i++) {
            int score = i * 10;
            System.out.println("adding " + score);
            scoreRecord.addScore(score);
        }

    }
}
