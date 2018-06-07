package practice.p04_petercoad_inheritance_rules;

// 직장인 클래스
public class Worker extends Role {

    @Override
    public void doIt() {
        System.out.println("Working");  // 오버라이딩
    }
}
