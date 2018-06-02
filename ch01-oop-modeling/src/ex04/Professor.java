package ex04;

// 양방향 연관관계
public class Professor {

    private Student student;

    public void setStudent(Student student) {
        this.student = student;
    }

    public void advice() {
        student.advice("상담내용...");
    }
}
