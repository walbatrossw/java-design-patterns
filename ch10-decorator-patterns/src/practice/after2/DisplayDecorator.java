package practice.after2;

// 다양한 추가 기능에 대한 공통 추상 클래스
public abstract class DisplayDecorator extends Display {

    private Display decoratedDisplay;   // 출력 클래스 참조 변수

    //생성자
    public DisplayDecorator(Display decoratedDisplay) {
        this.decoratedDisplay = decoratedDisplay;
    }

    // 출력 메서드 오버라이드
    @Override
    public void draw() {
        decoratedDisplay.draw();
    }

}
