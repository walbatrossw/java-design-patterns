package ex06;

import java.util.Vector;

// 다대다 연관 관계 설정 : 학생(N) ------- 수업(N)
public class Course {

    private String name;
    private Vector<Student> students;

    // 생성자
    public Course(String name) {
        this.name = name;
        this.students = new Vector<>();
    }

    // 학생 등록
    public void addStudent(Student student) {
        students.add(student);
    }

    // 학생 등록 취소
    public void removeStdent(Student student) {
        if (students.contains(student)) {
            students.remove(student);
        }
    }

    // 학생 목록 가져오기
    public Vector<Student> getStudents() {
        return students;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
