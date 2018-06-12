package practice.before;

// 로봇 추상 클래스
public abstract class Robot {

    private String name;

    public Robot(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract void attack();
    public abstract void move();

}
