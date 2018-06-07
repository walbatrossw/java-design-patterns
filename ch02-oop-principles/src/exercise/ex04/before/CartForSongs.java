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
            } else if (song.getDiscountMode().equals("BlackFridaySale")) {
                total = total + (song.getPrice() - 0.5 * song.getPrice());
            }else {
                total = total + song.getPrice();
            }
        }
        return total;
    }

    public void add(Song song) {
        cart.add(song);
    }

}

// 새로운 할인 모드가 생기면 calculateTotalPrice() 메서드가 변경되어야한다.
// 예를 들어 만약 새로운 할인인 blackFridaySale(50%할인) 이 추가되면 새로운 코드가 작성된다.
// 그렇다면 새로운 요구사항이 생길 때마다 매번 수정되어야만한다.
// 그렇기 때문에 일반화관계(상속)을 통해 할인 모드를 외부에 캡슐화할 필요가 있으며 다형성과 동적 바인딩을 통해 적합한 할인이 적용되게 해야한다.

// CartForSongs -----------> Song -------------> DiscountMode <--------------- OnSale, NonDiscount, TodaySale, BlackFridaySale, ChristmasSale,,,