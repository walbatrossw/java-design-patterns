package practice.p08;

// 가전제품 추상클래스를 상속 받은 티비 클래스
public class Tv extends HomeAppliances {

    @Override
    public void turnOn() {
        System.out.println("티비 전원 켜짐");
    }

    @Override
    public void turnOff() {
        System.out.println("티비 전원 꺼짐");
    }
}
