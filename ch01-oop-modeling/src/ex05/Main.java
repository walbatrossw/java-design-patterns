package ex05;

public class Main {
    public static void main(String[] args) {

        Student doubles = new Student("더블에스");
        Course os = new Course("운영체제");
        Course ds = new Course("자료구조");
        Course nt = new Course("네트워크");

        doubles.registerCourse(os);
        doubles.registerCourse(ds);
        doubles.registerCourse(nt);

        System.out.println(doubles);

        doubles.dropCourse(os);

        System.out.println(doubles);
    }
}
