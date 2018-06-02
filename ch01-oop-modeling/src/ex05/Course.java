package ex05;

// 단반향 관계 : 1대n
public class Course {

    private String courseName;  // 수업 이름

    // 생성자
    public Course(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    @Override
    public String toString() {
        return this.courseName;
    }
}
