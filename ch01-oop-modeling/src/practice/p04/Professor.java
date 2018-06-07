package practice.p04;

// 양방향 연관관계 : 1대1
public class Professor {

    private Student student; // 학생

    public void setStudent(Student student) {
        this.student = student;
    }

    public void advice() {
        student.advice("상담내용...");
    }
}
