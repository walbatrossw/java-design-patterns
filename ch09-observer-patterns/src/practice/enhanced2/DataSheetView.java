package practice.enhanced2;

import java.util.List;

// 통보대상
public class DataSheetView implements Observer {

    private ScoreRecord scoreRecord;    // 점수 저장 클래스 참조변수
    private int viewCount;              // 저장된 점수의 갯수

    // 생성자
    public DataSheetView(ScoreRecord scoreRecord, int viewCount) {
        this.scoreRecord = scoreRecord;
        this.viewCount = viewCount;
    }

    // 점수의 변경을 통보받아 갱신하는 메서드
    @Override
    public void update() {
        List<Integer> record = scoreRecord.getScoreRecord(); // 점수 조회
        displayScores(record, viewCount);
    }

    // 점수 출력 메서드
    private void displayScores(List<Integer> record, int viewCount) {
        System.out.println("List of " + viewCount + " entries ");
        for (int i = 0; i < viewCount &&  i < record.size(); i++) {
            System.out.println(record.get(i));
        }
        System.out.println();
    }

}
