package exercise.ex01;

// 싱글턴 확인
public class Singleton {

    //    private Singleton instance = null; // 정적 변수이야함
    private static Singleton instance = null;

//    public Singleton() {  // 접근제어자를 private 이어야함
//
//    }

    private Singleton() {

    }

//    public static Singleton getInstance() { // synchronized 키워드를 사용하여 동기화처리가 필수적임
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
