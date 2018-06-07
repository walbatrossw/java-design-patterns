package exercise.ex04.after;

import exercise.ex04.after.salemode.DiscountMode;

public class Song {

    private DiscountMode discountMode;

    public void setDiscountMode(DiscountMode discountMode) {
        this.discountMode = discountMode;
    }

    public double getPrice() {
        return 10.0 - (10.0 * this.discountMode.getDiscountRate());
    }
}
