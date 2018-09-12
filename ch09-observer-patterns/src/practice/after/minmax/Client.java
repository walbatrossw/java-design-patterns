package practice.after.minmax;

public class Client {
    public static void main(String[] args) {

        ScoreRecord scoreRecord = new ScoreRecord();    // 점수 저장 객체 생성
        MinMaxView minMaxView = new MinMaxView(scoreRecord);

        scoreRecord.setMinMaxView(minMaxView);

        for (int i = 1; i <= 5; i++) {
            int score = i * 10;
            System.out.println("adding " + score);  // 점수추가
            scoreRecord.addScore(score);    // 저장된 점수목록 출력
        }
    }
}
