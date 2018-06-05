package ex02.vectorstack;

import java.util.Vector;


public class VectorStack<String> { //extends Vector<String> {

    //private Vector<String> vectorList = this;

    private Vector<String> vectorList = new Vector<>();

    public void push(String element) {
        vectorList.add(element);
    }

    public String pop() {
        return vectorList.remove(size() - 1);
    }

    public boolean isEmpty() {
        return vectorList.isEmpty();
    }

    public int size() {
        return vectorList.size();
    }

}
