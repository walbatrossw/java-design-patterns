package practice.before;

public class TeakwonV extends Robot {

    public TeakwonV(String name) {
        super(name);
    }

    @Override
    public void attack() {
        System.out.println("I have Missile and can attack with it.");
    }

    @Override
    public void move() {
        System.out.println("I can only walk.");
    }
}
