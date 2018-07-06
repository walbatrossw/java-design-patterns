package exercise.ex03_code;

public class Client {
    public static void main(String[] args) {

        Light light = new Light();  // 형광등 객체 생성

        light.off_button_pushed();  // 반응 없음
        light.on_button_pushed();   // 켜짐
        light.on_button_pushed();   // 수면모드
        light.off_button_pushed();  // 꺼짐
        light.on_button_pushed();   // 켜짐
        light.on_button_pushed();   // 수면모드
    }
}
