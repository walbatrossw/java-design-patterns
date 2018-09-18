package exercise.ex02.codes;

public class AirBagDecorator extends CarOptionDecorator {

    private int airBagPrice;

    public AirBagDecorator(CarComponent decoratedCar, int airBagPrice) {
        super(decoratedCar);
        this.airBagPrice = airBagPrice;
    }

    @Override
    public int getPrice() {
        return super.getPrice() + getAirBagPrice();
    }

    @Override
    public String getCarInfo() {
        return super.getCarInfo() + " with AirBag";
    }

    private int getAirBagPrice() {
        return airBagPrice;
    }

}
