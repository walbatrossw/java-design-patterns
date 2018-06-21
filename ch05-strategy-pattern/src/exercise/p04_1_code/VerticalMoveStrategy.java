package exercise.p04_1_code;

// 수직 이동 전략
public class VerticalMoveStrategy extends DirectionsStrategy {

    @Override
    public void move(Ball ball) {
        ball.setIntervals(0, Ball.INTERVAL);    // 볼의 시작점에 위치
        while (true) {
            ball.setY(ball.getY() + ball.getYInterval());   // 공의 크기만큼 수직으로 이동
            if ((ball.getY() < 0 && ball.getYInterval() < 0) || ball.getY() + Ball.SIZE > BallFrame.HEIGHT - 40 && ball.getYInterval() > 0) {
                ball.setIntervals(0, -ball.getYInterval()); // 프레임의 경계에 도달했을때 진행 방향을 바꿈
            } try {
                Thread.sleep(30);
            } catch (InterruptedException e) {

            }
        }
    }

}
