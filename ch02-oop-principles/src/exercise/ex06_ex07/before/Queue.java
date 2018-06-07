package exercise.ex06_ex07.before;

import java.util.LinkedList;

public class Queue<String> extends LinkedList<String> {

    // Queue에서 element 추가
    public boolean addQueue(String element) {
        return this.offer(element);
    }

    // Queue에서 element 삭제
    public String removeQueue() {
        return this.poll();
    }

    // Queue에서 가장 먼저 추가된 element 반환
    public String peekQueue() {
        return this.peek();
    }
}

// 이 코드의 문제점은 LinkedList를 상속받음으로써 원하지 않는 속성과 연산을 함께 사용할수 있게되었다는 점이다.
// 이렇게 상속받지 않고, 위임을 통해 LinkedList 클래스에서 Queue에 필요한 연산만을 재사용해야한다.
// 그리고 A is a kind of B 의 관계 또한 성립되지 않는다.
// Queue가 LinkedList의 한 종류가 될 수 없기 때문이다.
