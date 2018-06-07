package practice.p02_inheritance_encapsulation.after;

// 일반화 관계 대신 위임방식으로 변경
public class Main {

    public static void main(String[] args) {
        MyStack<String> myStack = new MyStack<>();

        myStack.push("A");
        myStack.push("B");
        myStack.push("C");
        myStack.push("D");

        System.out.println(myStack.pop());
        System.out.println(myStack.pop());
        System.out.println(myStack.pop());
        System.out.println(myStack.pop());

    }

}

// 일반화 관계(상속)과 달리 필요한 연산과 속성만을 위임받아 사용할 수 있게 되었다.
// 기능을 재사용하기 위해서는 상속보다 위임을 이용하는 것이 바람직하다.
