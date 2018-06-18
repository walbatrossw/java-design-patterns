package exercise.p03;

public class MemberDiscountPricePolicy implements PricePolicy {

    @Override
    public int calcPrice(int price, int n) {
        return (int) (price * n * 0.9) ;
    }
}
