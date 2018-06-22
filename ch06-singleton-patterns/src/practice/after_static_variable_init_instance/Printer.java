package practice.after_static_variable_init_instance;

public class Printer {

    // 정적 변수에 Printer 인스턴스를 만들어 초기화
    private static Printer printer = new Printer();
    private int counter = 0;

    private Printer() {

    }

    public static Printer getPrinter() {
        return printer;
    }

    public void print(String str) {
        counter++;
        System.out.println(str);
    }

}
