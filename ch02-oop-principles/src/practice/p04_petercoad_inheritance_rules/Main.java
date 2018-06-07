package practice.p04_petercoad_inheritance_rules;

public class Main {
    public static void main(String[] args) {

        Person doubles = new Person();  // 사람 객체 생성

        doubles.setRole(new Driver());  // 운전자로 역할 변경
        doubles.doIt();

        doubles.setRole(new Worker());  // 직장인으로 역할 변경
        doubles.doIt();

        doubles.setRole(new SoccerPlayer()); // 축구 선수로 역할 변경
        doubles.doIt();
    }
}
