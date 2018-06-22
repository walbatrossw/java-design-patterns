package practice.before;

public class Printer {

    private static Printer printer = null;

    private Printer() {

    }

    public static Printer getPrinter() {

        // 프린터 인스턴스 생성 여부 확인
        if (printer == null) {
            printer = new Printer(); // 프린터 인스턴스 생성
        }

        return printer;
    }

    public void print(String str) {
        System.out.println(str);
    }
}
