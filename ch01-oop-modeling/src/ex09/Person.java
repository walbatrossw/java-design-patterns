package ex09;

// 의존관계
public class Person {

    private Car owns;

    public void setCar(Car car) {
        this.owns = car;
    }

    public Car getCar() {
        return this.owns;
    }
}
