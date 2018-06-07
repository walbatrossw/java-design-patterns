package practice.p05;

// 단반향 관계 : 1대n, 단방향관계이기 때문에 Student 객체를 참조하는 속성은 정의되지 않음
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
