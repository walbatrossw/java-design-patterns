package practice.before;

public class Client {
    public static void main(String[] args) {

        Robot taekwonV = new TeakwonV("TaekwonV");
        Robot atom = new Atom("Atom");

        System.out.println("My name is " + taekwonV.getName());
        taekwonV.move();
        taekwonV.attack();

        System.out.println("My name is " + atom.getName());
        atom.move();
        atom.attack();

    }
}
