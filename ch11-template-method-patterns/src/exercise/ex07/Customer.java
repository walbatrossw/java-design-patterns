package exercise.ex07;

// 고객 클래스
public class Customer {

    private String name;    // 고객명
    private int point;      // 포인트

    // 생성자
    public Customer(String name, int point) {
        this.name = name;
        this.point = point;
    }

    // getter, setter
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

}
