package exercise.ex04_diagram.after.salemode;

public class NonDiscount extends DiscountMode {
    @Override
    public double getDiscountRate() {
        return 0.0;
    }
}
