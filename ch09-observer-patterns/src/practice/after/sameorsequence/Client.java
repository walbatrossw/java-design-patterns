package practice.after.sameorsequence;

public class Client {
    public static void main(String[] args) {

        ScoreRecord scoreRecord = new ScoreRecord();    // 점수 저장 객체 생성

        DataSheetView dataSheetView3 = new DataSheetView(scoreRecord, 3);

        DataSheetView dataSheetView5 = new DataSheetView(scoreRecord, 5);
        MinMaxView minMaxView = new MinMaxView(scoreRecord);

        scoreRecord.addDataSheetView(dataSheetView3);
        scoreRecord.addDataSheetView(dataSheetView5);
        scoreRecord.setMinMaxView(minMaxView);

        for (int i = 1; i <= 5; i++) {
            int score = i * 10;
            System.out.println("adding " + score);
            scoreRecord.addScore(score);
        }
    }
}
