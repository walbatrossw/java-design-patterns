package practice.enhanced2;

import java.util.ArrayList;
import java.util.List;

// 구체적인 변경 감시 대상 데이터
public class ScoreRecord extends Subject {

    private List<Integer> scores = new ArrayList<>();

    // 점수 추가
    public void addScore(int score) {
        scores.add(score);
        notifyObservers();  // 데이터의 변경을 각 옵서버에게 통지
    }

    public List<Integer> getScoreRecord() {
        return scores;
    }

}
