package practice.before;

import java.util.List;

public class DataSheetView {

    private ScoreRecord scoreRecord;
    private int viewCount;

    public DataSheetView(ScoreRecord scoreRecord, int viewCount) {
        this.scoreRecord = scoreRecord;
        this.viewCount = viewCount;
    }

    // 점수의 변경을 통보받음
    public void update() {
        List<Integer> record = scoreRecord.getScoreRecord(); // 점수 조회
        displayScores(record, viewCount);
    }

    // 점수 출력
    private void displayScores(List<Integer> record, int viewCount) {
        System.out.println("List of " + viewCount + " entries ");
        for (int i = 0; i < viewCount &&  i < record.size(); i++) {
            System.out.println(record.get(i));
        }
        System.out.println();
    }

}
