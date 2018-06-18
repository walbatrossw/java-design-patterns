package exercise.p03;

public class Member {

    private String name;
    private int accPrice;

    public Member(String name) {
        this.name = name;
        this.accPrice = 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAccPrice() {
        return accPrice;
    }

    public void setAccPrice(int accPrice) {
        this.accPrice = accPrice;
    }

    public void addAccPrice(int price) {
        accPrice += price;
    }
}
