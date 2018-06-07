package practice.p02_inheritance_encapsulation.before;

import java.util.ArrayList;

// 일반화(상속)을 통한 기능 재사용
public class MyStack<String> extends ArrayList<String> {

    public void push(String element) {
        add(element);
    }

    public String pop() {
        return remove(size() - 1);
    }

}
