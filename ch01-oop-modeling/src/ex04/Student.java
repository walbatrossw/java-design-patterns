package ex04;

// 양방향 연관 관계
public class Student {

    private Professor advisor;

    public void setAdvisor(Professor advisor) {
        this.advisor = advisor;
    }

    public void advice(String msg) {
        System.out.println(msg);
    }

}
