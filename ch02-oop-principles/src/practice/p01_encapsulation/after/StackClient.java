package practice.p01_encapsulation.after;

public class StackClient {

    public static void main(String[] args) {
        ArrayStack stack = new ArrayStack(10);
        stack.push(20);
        System.out.println(stack.peek());
    }
}

// push, pop, peek 메서드의 연산만으로 스택을 사용할 수 있게 됨
// push, pop, peek 메서드 등이 어떤 방식으로 어떤 자료구조를 사용해 작업을 실행하는지는 알 수 없다.
// 즉 스택과 이를 사용하는 코드의 결합이 낮아지는 것이다.