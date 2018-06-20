package exercise.p03_1_code;

public class Rental {

    private Member member;
    private Book book;
    private PricePolicy pricePolicy;
    private int n;

    public Rental(Member member, Book book, PricePolicy pricePolicy, int n) {
        this.member = member;
        this.book = book;
        this.pricePolicy = pricePolicy; // 가격정책 주입
        this.n = n;
        this.member.addAccPrice(pricePolicy.calcPrice(book.getPrice(), n));
    }

    public int getPrice() {
        return pricePolicy.calcPrice(book.getPrice(), n);   // 가격 정책에 따라 책 가격 계산
    }

}
