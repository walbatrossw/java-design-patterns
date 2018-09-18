package exercise.ex02.codes;

public class NaviDecorator extends CarOptionDecorator {

    private int naviPrice;

    public NaviDecorator(CarComponent decoratedCar, int naviPrice) {
        super(decoratedCar);
        this.naviPrice = naviPrice;
    }

    @Override
    public int getPrice() {
        return super.getPrice() + getNaviPrice();
    }

    @Override
    public String getCarInfo() {
        return super.getCarInfo() + " with Navi";
    }

    public int getNaviPrice() {
        return naviPrice;
    }
}
