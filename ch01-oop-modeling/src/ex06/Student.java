package ex06;

import java.util.Vector;

// 다대다 연관 관계 설정 : 학생(N) ------- 수업(N)
public class Student {

    private String name;
    private Vector<Course> courses;

    // 생성자
    public Student(String name) {
        this.name = name;
        this.courses = new Vector<>();
    }

    // 수업 등록
    public void registerCourse(Course course) {
        courses.add(course);
        course.addStudent(this);
    }

    // 수업 등록 취소
    public void dropCourse(Course course) {
        if (courses.contains(course)) {
            courses.remove(course);
            course.removeStdent(this);
        }
    }

    // 수업 목록 가져오기
    public Vector<Course> getCourses() {
        return courses;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
