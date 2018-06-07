package practice.p08;

// 가전제품 추상클래스를 상속 받은 세탁기 클래스
public class Washer extends HomeAppliances {

    @Override
    public void turnOn() {
        System.out.println("세탁기 전원 켜짐");
    }

    @Override
    public void turnOff() {
        System.out.println("세탁기 전원 꺼짐");
    }

}
