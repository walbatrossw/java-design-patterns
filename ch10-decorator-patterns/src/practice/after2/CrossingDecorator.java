package practice.after2;

public class CrossingDecorator extends DisplayDecorator {

    // 기존의 도로 표시 클래스 설정
    public CrossingDecorator(Display decoratedDisplay) {
        super(decoratedDisplay);
    }

    @Override
    public void draw() {
        super.draw();   // 설정된 기존의 표시 기능을 실행
        drawCrossing(); // 추가적으로 교차로를 표시
    }

    private void drawCrossing() {
        System.out.println("\t교차로 표시");
    }

}
