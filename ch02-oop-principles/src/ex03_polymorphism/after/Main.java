package ex03_polymorphism.after;

public class Main {
    public static void main(String[] args) {
        Pet[] p = {new Cat(), new Dog(), new Parrot()};
        groupTalk(p);
    }
    public static void groupTalk(Pet[] p) {
        int i;
        for (i = 0; i < 3; i++) {
            p[i].talk();
        }
    }
}
