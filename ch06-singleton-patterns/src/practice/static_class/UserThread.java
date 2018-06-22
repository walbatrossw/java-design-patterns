package practice.static_class;

public class UserThread extends Thread {

    // 스레드 생성
    public UserThread(String name) {
        super(name);
    }

    // 현재 스레드 이름 출력
    public void run() {
        Printer.paint(Thread.currentThread().getName() + " print using" + ".");
    }

}
