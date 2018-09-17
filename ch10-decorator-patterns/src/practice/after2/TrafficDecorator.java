package practice.after2;

// 교통량 표시를 추가하는 클래스 : 추가 기능에 대한 공통 클래스 상속
public class TrafficDecorator extends DisplayDecorator {

    // 생성자
    public TrafficDecorator(Display decoratedDisplay) {
        super(decoratedDisplay);
    }

    // 출력 메서드 오버라이드
    @Override
    public void draw() {
        super.draw();
        drawTraffic();
    }

    // 교통량 표시 메서드
    private void drawTraffic() {
        System.out.println("\t교통량 표시");
    }

}
