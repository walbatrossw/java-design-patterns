package ex05;

import java.util.Vector;

// 단반향 관계 : 1대n
public class Student {

    private String name;            // 학생이름
    private Vector<Course> courses; // 수강과목들

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
