package ex01.before;

public class StackClient {
    public static void main(String[] args) {

        ArrayStack stack = new ArrayStack(10);

        stack.itemArray[++stack.top] = 20;
        System.out.println(stack.itemArray[stack.top]);
    }
}

// ArrayStack 클래스의 push나 pop메서드를 사용하지 않고도 직접 배열에 값을 저장할 수 있다.
// 이런 경우 ArrayStack과 StackClient클래스는 강한 결합이 발생하게 된다.
// ArrayStack 클래스를 사용해 스택 구현이 변경되면 StackClient 클래스도 따라서 변경이 되어야한다.
// 이렇게 되는 이유는 StackClient 클래스가 은닉된 정보를 직접 사용했기 때문이다.
// 따라서 은닉정보가 변경되면 해당정보를 사용한 쪽도 모두 변경되어야만한다.
