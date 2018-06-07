package exercise.ex04.after.salemode;

public class NonDiscount extends DiscountMode {
    @Override
    public double getDiscountRate() {
        return 0.0;
    }
}
