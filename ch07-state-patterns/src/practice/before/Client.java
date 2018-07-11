package practice.before;

// 클라이언트 클래스
public class Client {
    public static void main(String[] args) {
        Light light = new Light();  // 형광등 객체 생성
        light.off_button_pushed();  // 형광등 꺼진 상태 : 반응 없음
        light.on_button_pushed();   // 형광등 켜진 상태 : 켜짐
        light.off_button_pushed();  // 형광등 켜진 상태 : 꺼짐
    }
}
