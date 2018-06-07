package practice.p01_encapsulation.before;

// 캡슐화를 위한 ArrayStack 예제
public class ArrayStack {

    // 문제점은 자료구조에 모든 public 키워드를 붙여 외부에 공개되어 있다.
    public int top;
    public int[] itemArray;
    public int stackSize;

    // 생성자
    public ArrayStack(int stackSize) {
        this.itemArray = new int[stackSize];
        this.top = -1;
        this.stackSize = stackSize;
    }

    // 스택 공백 여부 확인
    public boolean isEmpty() {
        return (top == -1);
    }

    // 스택이 가득차있는지 확이
    public boolean isFull() {
        return (top == this.stackSize - 1);
    }

    // 스택에 item 추가
    public void push(int item) {
        if (isFull()) {
            System.out.println("Inserting fail! ArrayStack is full.");
        } else {
            itemArray[++top] = item;
            System.out.println("Inserted Item : " + item);
        }
    }

    // 스택에 item 제거
    public int pop() {
        if (isEmpty()) {
            System.out.println("Deleting fail! ArrayStack is empty.");
            return -1;
        } else {
            return itemArray[top--];
        }
    }

    // 스택 top의 item 반환
    public int peek() {
        if (isEmpty()) {
            System.out.println("Peeking fail! ArrayStack is empty.");
            return -1;
        } else {
            return itemArray[top];
        }
    }
    
}
