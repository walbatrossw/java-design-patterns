package practice.p03_lsp;

public class Main {

    public static void main(String[] args) {

        Bag b1 = new Bag();
        Bag b2 = new Bag();

        DiscountedBag b3 = new DiscountedBag();
        DiscountedBag b4 = new DiscountedBag();

        b1.setPrice(50000);
        System.out.println(b1.getPrice());

        b2.setPrice(b1.getPrice());
        System.out.println(b2.getPrice());

        b3.setPrice(50000);
        System.out.println(b3.getPrice());

        b4.setPrice(b3.getPrice());
        System.out.println(b4.getPrice());

        b3.setDiscounted(0.1);
        b3.setPrice(50000);
        System.out.println(b3.getPrice());
    }

}
