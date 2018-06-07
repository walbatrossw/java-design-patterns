package exercise.ex06_ex07.after;

import java.util.LinkedList;

public class Queue<String> {

    // LinkedList 클래스를 상속받지 않고 필요한 연산과 속성을 위임받기 위해 필드로 선언
    private LinkedList<String> queueList = new LinkedList<>();

    // Queue에 element 추가
    public boolean addQueue(String element) {
        return queueList.offer(element);
    }

    // Queue에 첫번째 element 제거
    public String removeQueue() {
        return queueList.poll();
    }

    // Queue에 첫번째 element 반환
    public String peekQueue() {
        return queueList.peek();
    }

}
