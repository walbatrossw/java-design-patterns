package exercise.ex04_code;

import java.util.ArrayList;

public class PrinterManager {

    private static PrinterManager printerManager;

    private ArrayList<Printer> managedPrinter = new ArrayList<>();

    private PrinterManager() {
        managedPrinter.add(new Printer());
        managedPrinter.add(new Printer());
        managedPrinter.add(new Printer());
    }

    public synchronized static PrinterManager getPrinterManager() {
        if (printerManager == null) {
            printerManager = new PrinterManager();
        }
        return printerManager;
    }

    public Printer getPrinter() {
        while (true) {
            for (Printer printer : managedPrinter) {
                if (printer.isAvailable()) {
                    printer.setAvailable(false);
                    return printer;
                }
            }
        }
    }

}
