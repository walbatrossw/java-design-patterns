package ex03_polymorphism.before;

public class Main {
    public static void main(String[] args) {
        Dog d = new Dog();
        Cat c = new Cat();
        Parrot p = new Parrot();
        d.bark();
        c.meow();
        p.sing();
    }
}
