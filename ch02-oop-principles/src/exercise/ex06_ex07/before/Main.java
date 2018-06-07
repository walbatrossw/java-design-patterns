package exercise.ex06_ex07.before;

public class Main {

    public static void main(String[] args) {

        Queue<String> queue = new Queue<>();

        queue.addQueue("A");
        queue.addQueue("B");
        queue.addQueue("C");
        queue.addQueue("D");
        //queue.add(1, "E");  // 허용되어서는 안된다. Queue의 FIFO에 위배된다.

        System.out.println(queue);

        System.out.println(queue.peekQueue());

        System.out.println(queue.removeQueue());

        System.out.println(queue);
    }
}

// 위의 코드에서 처럼 Queue 클래스가 LinkedList 클래스를 상속받음으로써 LinkedList 클래스의 모든 속성과 연산을 사용할수 있게 됨에따라
// 문제가 발생하게 된다.