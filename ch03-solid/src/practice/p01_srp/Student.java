package practice.p01_srp;

// 학생 클래스는 너무나 많은 책임을 수행해야한다.
public class Student {

    // 학생 클래스가 잘할 수 있는 것
    public void getCourse() {

    }

    // 학생 클래스가 잘할 수 있는 것
    public void addCourse(Course course) {

    }

    // 다른 클래스가 잘할 수 있는 것
    public void save() {

    }

    // 다른 클래스가 잘할 수 있는 것
    public Student load() {

        return new Student();
    }

    // 다른 클래스가 잘할 수 있는 것
    public void printOnReportCard() {

    }

    // 다른 클래스가 잘할 수 있는 것
    public void printOnAttendanceBook() {

    }
}
