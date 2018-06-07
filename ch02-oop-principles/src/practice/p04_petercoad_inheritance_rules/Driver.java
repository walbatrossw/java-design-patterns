package practice.p04_petercoad_inheritance_rules;

// 운전자 클래스
public class Driver extends Role {

    @Override
    public void doIt() {
        System.out.println("Driving");  // 오버라이딩
    }
}
