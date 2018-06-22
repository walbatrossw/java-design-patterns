package practice.before_thread;

public class Printer {

    private static Printer printer = null;
    private int counter = 0;

    private Printer() {

    }

    public static Printer getPrinter() {

        // 프린터 인스턴스 생성 여부 확인
        if (printer == null) {

            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {

            }
            printer = new Printer(); // 프린터 인스턴스 생성

        }

        return printer;
    }

    public void print(String str) {
        counter++; // 카운터 값 증가
        System.out.println(str + counter);
    }
}
