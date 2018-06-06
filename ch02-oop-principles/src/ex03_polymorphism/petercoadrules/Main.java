package ex03_polymorphism.petercoadrules;

public class Main {
    public static void main(String[] args) {
        Person doubles = new Person();
        doubles.setRole(new Driver()); // 운전자로 역할 변경
        doubles.doIt();
        doubles.setRole(new Worker()); // 직장인으로 역할 변경
        doubles.doIt();
    }
}
