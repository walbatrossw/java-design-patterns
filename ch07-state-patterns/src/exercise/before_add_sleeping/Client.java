package exercise.before_add_sleeping;

// 클라이언트 클래스
public class Client {
    public static void main(String[] args) {

        Light light = new Light();

        light.off_button_pushed();  // 반응 없음

        light.on_button_pushed();   // 불 켜짐
        light.on_button_pushed();   // 취침등
        light.on_button_pushed();   // 불켜짐

        light.off_button_pushed();  // 불꺼짐

    }
}
