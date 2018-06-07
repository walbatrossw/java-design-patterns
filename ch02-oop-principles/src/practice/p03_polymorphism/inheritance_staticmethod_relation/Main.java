package practice.p03_polymorphism.inheritance_staticmethod_relation;

public class Main {

    public static void main(String[] args) {
        A a = new A1();
        A1 a1 = new A1();

        a.doIt();
        a.doThat();
        a1.doIt();
    }

}

// 정적 메서드는 상속을 통해 오버라이드되지 않는다.
// 정적 메서드를 실행할 때 동적 바인딩을 실행하는 것이 아니고
// 컴파일할 때 객체의 타입에 따라 실행될 메서드가 결정된다.