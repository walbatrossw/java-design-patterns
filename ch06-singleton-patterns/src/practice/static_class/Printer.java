package practice.static_class;

public class Printer {

    private static int counter = 0;

    // 메서드 동기화
    public synchronized static void paint(String str) {
        counter++;  // 카운터값 증가
        System.out.println(str + counter);
    }
}
