package practice.after_static_variable_init_instance;

public class Client {

    private static final int USER_NUM = 5;

    public static void main(String[] args) {

        User[] users = new User[USER_NUM]; // 5명의 사용자 인스턴스 생성

        for (int i = 0; i < USER_NUM; i++) {
            users[i] = new User((i + 1) + " - user");
            users[i].print();
        }

    }
}
