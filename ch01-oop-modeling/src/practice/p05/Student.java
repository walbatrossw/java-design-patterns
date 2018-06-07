package practice.p05;

import java.util.Vector;

// 단반향 관계 : 1대N
public class Student {

    private String name;            // 학생이름
    private Vector<Course> courses; // 수강과목들 : 컬렉션 자료구조를 통해 여러개의 Course 클래스 객체를 참조할 수 있음

    //  생성자
    public Student(String name) {
        this.name = name;
        this.courses = new Vector<>();
    }

    //  수강 등록
    public void registerCourse(Course course) {
        courses.add(course);
    }

    //  수강 취소
    public void dropCourse(Course course) {
        if (courses.contains(course)) {
            courses.remove(course);
        }
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", courses=" + courses +
                '}';
    }
}
