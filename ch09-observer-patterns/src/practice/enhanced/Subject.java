package practice.enhanced;

import java.util.ArrayList;
import java.util.List;

// 추상화된 변경 관심 데이터
public abstract class Subject {

    // 추상화된 통보 대상 목록
    private List<Observer> observers = new ArrayList<>();

    // 옵서버(통보 대상) 추가
    public void attach(Observer observer) {
        observers.add(observer);
    }

    // 옵서버(통보 대상) 제거
    public void detach(Observer observer) {
        observers.remove(observer);
    }

    // 통보대상 목록에서 각 옵서버에게 변경을 통보
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update();
        }
    }

}
