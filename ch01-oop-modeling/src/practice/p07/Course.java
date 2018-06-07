package practice.p07;

import java.util.Iterator;
import java.util.Vector;

// 연관 클래스 학생(N) -------- 성적 -------- 수업(N)
public class Course {

    private String name;                    // 수업명
    private Vector<Transcript> transcripts; // 학생들의 성적들

    // 생성자
    public Course(String name) {
        this.name = name;
        this.transcripts = new Vector<>();
    }

    // 성적 등록
    public void addTranscript(Transcript transcript) {
        transcripts.add(transcript);
    }

    // 학생 목록
    public Vector<Student> getStudents() {
        Vector<Student> students = new Vector<>();
        Iterator<Transcript> iterator = transcripts.iterator();

        while (iterator.hasNext()) {
            Transcript transcript = iterator.next();
            students.add(transcript.getStudent());
        }
        return students;
    }

    public String getName() {
        return name;
    }
}
