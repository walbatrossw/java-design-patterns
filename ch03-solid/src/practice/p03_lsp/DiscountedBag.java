package practice.p03_lsp;

public class DiscountedBag extends Bag {

    private double discountedRate;

    public void setDiscounted(double discountedRate) {
        this.discountedRate = discountedRate;
    }

    public void setPrice(int price) {
        super.setPrice(price - (int) (discountedRate * price));
    }

}
