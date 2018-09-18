package exercise.ex02.codes;

public class CarOptionDecorator extends CarComponent {

    private CarComponent decoratedCar;

    public CarOptionDecorator(CarComponent decoratedCar) {
        this.decoratedCar = decoratedCar;
    }

    @Override
    public int getPrice() {
        return decoratedCar.getPrice();
    }

    @Override
    public String getCarInfo() {
        return decoratedCar.getCarInfo();
    }
}
