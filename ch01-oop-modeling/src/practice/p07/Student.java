package practice.p07;

import java.util.Iterator;
import java.util.Vector;

// 연관 클래스 학생(N) -------- 성적 -------- 수업(N)
public class Student {

    private String name;                    // 학생이름
    private Vector<Transcript> transcripts; // 학생의 성적들

    // 생성자
    public Student(String name) {
        this.name = name;
        this.transcripts = new Vector<>();
    }

    // 성적 입력
    public void addTranscript(Transcript transcript) {
        transcripts.add(transcript);
    }

    // 과목들
    public Vector<Course> getCourses() {

        Vector<Course> courses = new Vector<>();
        Iterator<Transcript> iterator = transcripts.iterator();

        while (iterator.hasNext()) {
            Transcript transcript = iterator.next();
            courses.add(transcript.getCourse());
        }

        return courses;
    }

    public String getName() {
        return name;
    }
}
