package exercise.ex04_code;

public class UserThread extends Thread {

    private Printer myPrinter;

    public UserThread(String name) {
        super(name);
    }

    public void run() {
        PrinterManager printerManager = PrinterManager.getPrinterManager();
        myPrinter = printerManager.getPrinter();
        myPrinter.print(getName());
    }
}
