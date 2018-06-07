package exercise.ex04.before;

import java.util.ArrayList;
import java.util.Iterator;

public class CartForSongs {

    ArrayList<Song> cart = new ArrayList<>();

    public double calculateTotalPrice() {
        double total = 0.0;

        Iterator<Song> iterator = cart.iterator();

        while (iterator.hasNext()) {
            Song song = iterator.next();
            if (song.getDiscountMode().equals("OnSale")) {
                total = total + (song.getPrice() - 0.1 * song.getPrice());
            } else if (song.getDiscountMode().equals("TodayEvent")) {
                total = total + (song.getPrice() - 0.3 * song.getPrice());
            } else {
                total = total + song.getPrice();
            }
        }
        return total;
    }

    public void add(Song song) {
        cart.add(song);
    }

}
