package practice.after.minmax;

import java.util.ArrayList;
import java.util.List;

public class ScoreRecord {

    private List<Integer> scores = new ArrayList<>();   // 점수 저장
//    private DataSheetView dataSheetView;                // 목록 형태로 점수를 출력하는 클래스 참조 변수
    private MinMaxView minMaxView;

//    public void setDataSheetView(DataSheetView dataSheetView) {
//        this.dataSheetView = dataSheetView;
//    }

    // MinMaxView 설정 추가
    public void setMinMaxView(MinMaxView minMaxView) {
        this.minMaxView = minMaxView;
    }

    // 새로운 점수 추가
    public void addScore(int score) {
        scores.add(score);  // scores 목록에 주어진 점수를 추가
        //dataSheetView.update(); // scores 변경 통보
        minMaxView.update();    // scores 변경 통보 변경
    }

    // 점수 목록 가져오기
    public List<Integer> getScoreRecord() {
        return scores;
    }

}
