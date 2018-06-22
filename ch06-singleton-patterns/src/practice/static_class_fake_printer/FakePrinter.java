package practice.static_class_fake_printer;

// 테스트용 가짜 프린터
public class FakePrinter implements Printer {

    private String str;

    @Override
    public void print(String str) {
        this.str = str;
    }

    public String get() {
        return str;
    }
}
