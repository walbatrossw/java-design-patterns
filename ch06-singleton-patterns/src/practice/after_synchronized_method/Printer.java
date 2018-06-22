package practice.after_synchronized_method;

public class Printer {

    private static Printer printer = null;
    private int count = 0;

    private Printer() {

    }

    // 동기화
    public synchronized static Printer getPrinter() {

        // 프린터 인스턴스 생성 여부 확인
        if (printer == null) {
            printer = new Printer(); // 프린터 인스턴스 생성
        }

        return printer;
    }

    public void print(String str) {
        // 오직 하나의 스레드만 접근을 허용
        synchronized (this) {
            count++;
            System.out.println(str + count);
        }
    }
}
