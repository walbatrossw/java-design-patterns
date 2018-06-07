package practice.p07;

// 연관 클래스 학생(N) -------- 성적 -------- 수업(N)
public class Transcript {

    private Student student;    // 학생
    private Course course;      // 수업
    private String date;        // 일자
    private String grade;       // 성적

    // 생성자
    public Transcript(Student student, Course course) {
        this.student = student;
        this.student.addTranscript(this);
        this.course = course;
        this.course.addTranscript(this);
    }

    // getter, setter
    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

}
