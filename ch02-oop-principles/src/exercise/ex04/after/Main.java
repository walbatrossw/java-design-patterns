package exercise.ex04.after;

import exercise.ex04.after.salemode.*;

public class Main {
    public static void main(String[] args) {

        Song song1 = new Song();
        song1.setDiscountMode(new BlackFridaySale());
        Song song2 = new Song();
        song2.setDiscountMode(new ChristmasSale());
        Song song3 = new Song();
        song3.setDiscountMode(new NonDiscount());
        Song song4 = new Song();
        song4.setDiscountMode(new OnSale());
        Song song5 = new Song();
        song5.setDiscountMode(new TodaySale());

        CartForSongs cart = new CartForSongs();
        cart.add(song1);
        cart.add(song2);
        cart.add(song3);
        cart.add(song4);
        cart.add(song5);

        System.out.println(cart.calculateTotalPrice());
    }
}
