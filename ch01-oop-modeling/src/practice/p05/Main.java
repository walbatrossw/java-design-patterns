package practice.p05;

public class Main {
    public static void main(String[] args) {

        // 학생 객체 생성
        Student doubles = new Student("더블에스");

        // 수업 객체 생성
        Course os = new Course("운영체제");
        Course ds = new Course("자료구조");
        Course nt = new Course("네트워크");

        // 학생 객체에서 수업 등록
        doubles.registerCourse(os);
        doubles.registerCourse(ds);
        doubles.registerCourse(nt);

        System.out.println(doubles);

        // 학생 객체에서 수업 등록 취소
        doubles.dropCourse(os);

        System.out.println(doubles);
    }
}
