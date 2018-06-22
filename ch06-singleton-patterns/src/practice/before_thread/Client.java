package practice.before_thread;

public class Client {

    private static final int THREAD_NUM = 5;

    public static void main(String[] args) {
        UserThread[] user = new UserThread[THREAD_NUM];
        for (int i = 0; i < THREAD_NUM; i++) {
            user[i] = new UserThread((i + 1) +  " - Thread");
            user[i].start();
        }
    }

}
