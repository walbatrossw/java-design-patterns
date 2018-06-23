package exercise.ex01;

import practice.static_class_fake_printer.Printer;

public class Singleton {

    //    private Singleton instance = null;
    private static Singleton instance = null;

//    public Singleton() {
//
//    }

    private Singleton() {

    }


//    public static Singleton getInstance() {
//        if (instance == null) {
//            instance = new Singleton();
//        }
//        return instance;
//    }

    public synchronized static Singleton getInstance() {
        if (instance == null) {
            instance =  new Singleton();
        }
        return instance;
    }

    public void doSomething() {
        //...
    }
}
