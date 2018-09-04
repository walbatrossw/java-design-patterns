package exercise.ex03.ex03_3_4;

// 엘리베이터 내부 / 외부에서 엘리베이터를 이동 요청을 하는 버튼 클래스
public class ElevatorButton {

    // 커맨드 객체
    private Command command;

    // 생성자
    public ElevatorButton(Command command) {
        this.command = command;
    }

    // 버튼 눌림 감지
    public void pressed() {
        command.execute();
    }

}
