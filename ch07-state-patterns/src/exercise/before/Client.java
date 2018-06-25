package exercise.before;

// 클라이언트 클래스
public class Client {
    public static void main(String[] args) {
        Light light = new Light();
        light.off_button_pushed();
        light.on_button_pushed();
        light.off_button_pushed();
    }
}
