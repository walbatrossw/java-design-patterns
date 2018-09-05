package practice.enhanced;
import java.util.Collections;
import java.util.List;

// 통보대상 클래스
public class MinMaxView implements Observer {

    private ScoreRecord scoreRecord;

    public MinMaxView(ScoreRecord scoreRecord) {
        this.scoreRecord = scoreRecord;
    }

    @Override
    public void update() {
        List<Integer> record = scoreRecord.getScoreRecord();
        displayMinMax(record);
    }

    private void displayMinMax(List<Integer> record) {
        int min = Collections.min(record, null);
        int max = Collections.max(record, null);
        System.out.println("Min : " + min + ", Max : " + max);
        System.out.println();
        System.out.println("==============================");
    }

}
