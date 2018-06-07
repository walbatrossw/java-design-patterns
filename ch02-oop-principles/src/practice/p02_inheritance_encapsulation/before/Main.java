package practice.p02_inheritance_encapsulation.before;

// 일반화(상속)을 통한 기능 재사용
public class Main {
    public static void main(String[] args) {

        MyStack<String> myStack = new MyStack<>();

        myStack.push("A");
        myStack.push("B");
        myStack.push("C");
        myStack.add("C");   // 허용되어서는 안됨
        myStack.set(0, "D"); // 허용되어서는 안됨

        System.out.println(myStack.pop());
        System.out.println(myStack.pop());
        System.out.println(myStack.pop());

    }
}

// 불필요한 속성이나 연산도 함께 상속 받게됨에 따라 push(), pop() 메서드를 통하지 않고도 스택의 자료구조에 직접 접근이 가능해져버렸다.
// 스택의 무결조건은 LIFO에 위배된다.