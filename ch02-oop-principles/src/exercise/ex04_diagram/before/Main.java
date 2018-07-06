package exercise.ex04_diagram.before;

public class Main {
    public static void main(String[] args) {

        Song song1 = new Song();
        song1.setMode("NonDiscounted");

        Song song2 = new Song();
        song2.setMode("NonDiscounted");

        Song song3 = new Song();
        song3.setMode("OnSale");

        Song song4 = new Song();
        song4.setMode("TodayEvent");

        CartForSongs cart = new CartForSongs();
        cart.add(song1);
        cart.add(song2);
        cart.add(song3);
        cart.add(song4);

        System.out.println(cart.calculateTotalPrice());
    }
}
