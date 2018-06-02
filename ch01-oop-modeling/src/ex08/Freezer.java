package ex08;

// 가전제품 추상클래스를 상속 받은 냉장고 클래스
public class Freezer extends HomeAppliances {

    @Override
    public void turnOn() {
        System.out.println("냉장고 전원 켜짐");
    }

    @Override
    public void turnOff() {
        System.out.println("냉장고 전원 꺼짐");
    }
}
