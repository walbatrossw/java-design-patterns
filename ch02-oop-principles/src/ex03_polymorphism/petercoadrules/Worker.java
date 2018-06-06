package ex03_polymorphism.petercoadrules;

public class Worker extends Role {

    @Override
    public void doIt() {
        System.out.println("Working");
    }
}
