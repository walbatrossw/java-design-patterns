package exercise.ex04.after.salemode;

public class OnSale extends DiscountMode {

    @Override
    public double getDiscountRate() {
        return 0.1;
    }
}
