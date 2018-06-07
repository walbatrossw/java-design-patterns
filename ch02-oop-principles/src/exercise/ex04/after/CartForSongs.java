package exercise.ex04.after;

import java.util.ArrayList;
import java.util.Iterator;

public class CartForSongs {

    ArrayList<Song> cart = new ArrayList<>();

    public double calculateTotalPrice() {
        double total = 0.0;
        Iterator<Song> iterator = cart.iterator();

        while (iterator.hasNext()) {
            Song song = iterator.next();
            total = total + song.getPrice();
        }
        return total;
    }

    public void add(Song song) {
        cart.add(song);
    }

}
