package exercise.ex04_diagram.after.salemode;

public class BlackFridaySale extends DiscountMode {
    @Override
    public double getDiscountRate() {
        return 0.5;
    }
}
