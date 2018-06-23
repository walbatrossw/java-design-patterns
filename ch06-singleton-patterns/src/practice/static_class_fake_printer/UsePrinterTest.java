package practice.static_class_fake_printer;

import junit.framework.TestCase;

public class UsePrinterTest extends TestCase {

    public void testDoSomething() {

        FakePrinter fakePrinter = new FakePrinter();    // 가짜 프린터 객체 생성
        UsePrinter usePrinter = new UsePrinter();       // 프린터 사용 객체 생성

        String str = "this is a test";
        usePrinter.doSomething(fakePrinter, str);

        assertEquals("this is a test", fakePrinter.get());
    }

}
