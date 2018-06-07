package practice.p03_polymorphism.problem;

public class Lion extends Animal {

    @Override
    public void printName() {
        System.out.println("Lion");
    }

    public void ride() {
        System.out.println("Lion ride!!!!!!!!!!");
    }
}
