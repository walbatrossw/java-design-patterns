package exercise.ex02.codes;

public class SCCDecorator extends CarOptionDecorator {

    private int sccDecorator;

    public SCCDecorator(CarComponent decoratedCar, int sccDecorator) {
        super(decoratedCar);
        this.sccDecorator = sccDecorator;
    }

    @Override
    public int getPrice() {
        return super.getPrice() + getSccDecorator();
    }

    @Override
    public String getCarInfo() {
        return super.getCarInfo() + "with Smart Cruse Control";
    }

    public int getSccDecorator() {
        return sccDecorator;
    }
}
