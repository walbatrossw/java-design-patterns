package exercise.ex01.codes.after;

public class Client {
    public static void main(String[] args) {
        EmailContent simple = new BasicEmailContent("Hello");
        System.out.println(simple.getContent());

        EmailContent external = new ExternalDecorator(simple);
        System.out.println(external.getContent());

        EmailContent secure = new SecureDecorator(simple);
        System.out.println(secure.getContent());

        EmailContent secureAfterExternal = new SecureDecorator(external);
        System.out.println(secureAfterExternal.getContent());
    }
}
