package practice.p07;

import java.util.Vector;

public class Main {

    public static void main(String[] args) {

        // 학생 객체 생성
        Student kim = new Student("kim");
        Student lee = new Student("lee");

        // 과목 객체 생성
        Course java = new Course("Java");
        Course js = new Course("JavaScript");
        Course c = new Course("C");

        // 성적 객체 생성
        Transcript t1 = new Transcript(kim, java);
        Transcript t2 = new Transcript(kim, js);
        Transcript t3 = new Transcript(lee, c);
        Transcript t4 = new Transcript(kim, c);

        // 학생 객체에 성적과 일자 등록
        t1.setDate("2017");
        t1.setGrade("A+");

        t2.setDate("2017");
        t2.setGrade("B+");

        t3.setDate("2018");
        t3.setGrade("A+");

        t4.setDate("2018");
        t4.setGrade("A-");

        Vector<Course> courses;
        courses = kim.getCourses();
        System.out.print("Kim's courses : ");
        for (Course course : courses) {
            System.out.print(course.getName() + " ");
        }

        System.out.println();

        Vector<Student> students;
        students = c.getStudents();
        System.out.print("C Course's Students : ");
        for (Student student : students) {
            System.out.print(student.getName() + " ");
        }
    }

}
