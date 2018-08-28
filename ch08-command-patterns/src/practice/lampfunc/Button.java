package practice.lampfunc;

// 버튼 클래스
public class Button {

    private Lamp theLamp;

    // 생성자
    public Button(Lamp theLamp) {
        this.theLamp = theLamp;
    }

    // 버튼이 눌려졌음을 인식하는 메서드
    public void pressed() {
        theLamp.turnOn();
    }

}
