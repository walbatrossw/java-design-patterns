package practice.p04;

public class Main {
    public static void main(String[] args) {

        Professor professor = new Professor();
        Student student = new Student();

        professor.setStudent(student);
        student.setAdvisor(professor);

        student.advice("상담신청...");

        professor.advice();

    }
}
