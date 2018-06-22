package practice.static_class_fake_printer;

import junit.framework.TestCase;

public class UsePrinterTest extends TestCase {

    public void testSomething() {
        FakePrinter fakePrinter = new FakePrinter();
        UsePrinter usePrinter = new UsePrinter();
        usePrinter.doSomething(fakePrinter);
        assertEquals("this is a test", fakePrinter.get());
    }

}
