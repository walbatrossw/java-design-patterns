package ex03_polymorphism.petercoadrules;

// 직장인 클래스
public class Worker extends Role {

    @Override
    public void doIt() {
        System.out.println("Working");  // 오버라이딩
    }
}
