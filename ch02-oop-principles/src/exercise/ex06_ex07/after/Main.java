package exercise.ex06_ex07.after;

public class Main {
    public static void main(String[] args) {

        Queue<String> myQueue = new Queue<>();

        myQueue.addQueue("A");
        myQueue.addQueue("B");
        myQueue.addQueue("C");
        myQueue.addQueue("D");

        System.out.println(myQueue.peekQueue());
        System.out.println(myQueue.removeQueue());

    }
}
