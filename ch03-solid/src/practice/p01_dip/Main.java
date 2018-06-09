package practice.p01_dip;

public class Main {

    public static void main(String[] args) {
        // 아이 객체 생성
        Kid kid = new Kid();

        // 로봇 장난감 객체 생성, 주입
        Toy robot = new Robot();
        kid.setToy(robot);
        kid.play();

        // 레고 장난감 객체 생성, 주입 변경
        Toy lego = new Lego();
        kid.setToy(lego);
        kid.play();

    }
}
