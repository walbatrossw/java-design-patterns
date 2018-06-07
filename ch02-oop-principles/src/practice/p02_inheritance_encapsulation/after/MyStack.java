package practice.p02_inheritance_encapsulation.after;

import java.util.ArrayList;

// 3. 서브 클래스에서 일반화된 관계선언을 제거
public class MyStack<String> {
//public class MyStack<String> extends ArrayList<String> {

    // 1. 자식 클래스에 부모클래스의 인스턴스를 참조하는 속성 생성, this로 초기화
    //private ArrayList<String> arrayList = this;

    // 4. 위임 속성 필드에 슈퍼 클래스의 객체를 생성해 대입
    private ArrayList<String> arrayList = new ArrayList<>();

    // 2. 서브 클래스에 정의된 메서드에 1번에서 만든 위임 속성 필드를 참조하도록 변경
    public void push(String element) {
        //add(element);
        arrayList.add(element);
    }

    // 2. 서브 클래스에 정의된 메서드에 1번에서 만든 위임 속성 필드를 참조하도록 변경
    public String pop() {
        //return remove(size() - 1);
        return arrayList.remove(size() - 1);
    }

    // 5. 서브 클래스에서 사용된 슈퍼 클래스의 메서드에도 위임 메서드를 추가
    public boolean isEmpty() {
        return arrayList.isEmpty();
    }

    // 5. 서브 클래스에서 사용된 슈퍼 클래스의 메서드에도 위임 메서드를 추가
    public int size() {
        return arrayList.size();
    }

}
