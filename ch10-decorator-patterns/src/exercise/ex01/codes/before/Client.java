package exercise.ex01.codes.before;

public class Client {
    public static void main(String[] args) {
        BasicEmailContent basic = new BasicEmailContent("Hello");
        System.out.println(basic.getContent());

        ExternalEmailContent external = new ExternalEmailContent("Hello");
        System.out.println(external.getContent());

        SecureEmailContent secure = new SecureEmailContent("Hello");
        System.out.println(secure.getContent());
    }
}
