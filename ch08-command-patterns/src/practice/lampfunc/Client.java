package practice.lampfunc;

public class Client {

    public static void main(String[] args) {

        Lamp lamp = new Lamp(); // 램프 객체 생성
        Button button = new Button(lamp);   // 버튼 객체 생성
        button.pressed();   // 버튼 누르기

    }

}
