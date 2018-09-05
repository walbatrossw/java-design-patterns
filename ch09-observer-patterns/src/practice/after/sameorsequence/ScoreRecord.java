package practice.after.sameorsequence;

import java.util.ArrayList;
import java.util.List;

public class ScoreRecord {

    private List<Integer> scores = new ArrayList<>();                   // 점수 저장
    private List<DataSheetView> dataSheetViews = new ArrayList<>();     // 목록 형태로 점수 출력 리스트 참조변수
    private MinMaxView minMaxView;                                      // 최소/최대값 출력 참조변수

    public void addDataSheetView(DataSheetView dataSheetView) {
        dataSheetViews.add(dataSheetView);
    }

    // MinMaxView 설정 추가
    public void setMinMaxView(MinMaxView minMaxView) {
        this.minMaxView = minMaxView;
    }

    // 새로운 점수 추가
    public void addScore(int score) {
        scores.add(score);  // scores 목록에 주어진 점수를 추가
        // 각 dataSheetView에 값의 변경을 통보
        for (DataSheetView dataSheetView : dataSheetViews) {
            dataSheetView.update();
        }
        minMaxView.update();    // MinMaxView에 값의 변경 통보 변경
    }

    // 점수 목록 가져오기
    public List<Integer> getScoreRecord() {
        return scores;
    }

}
