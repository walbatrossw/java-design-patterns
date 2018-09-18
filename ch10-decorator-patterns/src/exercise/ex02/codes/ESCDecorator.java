package exercise.ex02.codes;

public class ESCDecorator extends CarOptionDecorator {

    private int escPrice;

    public ESCDecorator(CarComponent decoratedCar, int escPrice) {
        super(decoratedCar);
        this.escPrice = escPrice;
    }

    @Override
    public int getPrice() {
        return super.getPrice() + getEscPrice();
    }

    @Override
    public String getCarInfo() {
        return super.getCarInfo() + " with ESC";
    }

    public int getEscPrice() {
        return escPrice;
    }
}
