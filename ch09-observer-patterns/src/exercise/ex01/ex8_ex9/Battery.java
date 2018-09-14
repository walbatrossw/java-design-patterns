package exercise.ex01.ex8_ex9;

// 변경 관리 대상이 되는 데이터는 Subject를 상속
public class Battery extends Subject {

    private int level = 100;

    public void consume(int amount) {
        level -= amount;
        notifyObservers();  // 데이터 변경시 Subject 클래스의 notifyObserver() 메서드 호출
    }

    public int getLevel() {
        return level;
    }

}
