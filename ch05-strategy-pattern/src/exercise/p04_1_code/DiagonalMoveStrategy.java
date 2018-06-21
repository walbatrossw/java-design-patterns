package exercise.p04_1_code;

public class DiagonalMoveStrategy extends DirectionsStrategy {

    @Override
    public void move(Ball ball) {
        ball.setIntervals(Ball.INTERVAL, Ball.INTERVAL); // 공의 시작점을 설정함
        while (true) {
            // 대각선 방향으로 공의 크기만큼 공을 이동함
            ball.setX(ball.getX() +  ball.getXInterval());
            ball.setY(ball.getY() +  ball.getYInterval());
            if ((ball.getX() < 0 && ball.getXInterval() < 0) || ball.getX() + Ball.SIZE > BallFrame.WIDTH - 15 && ball.getXInterval() > 0) {
                ball.setIntervals(-ball.getXInterval(), ball.getYInterval());
            }
            if ((ball.getY() < 0 && ball.getYInterval() < 0) || ball.getY() + Ball.SIZE > BallFrame.HEIGHT - 40 && ball.getYInterval() > 0) {
                // 프레임의 경계에 도달했을 때 공의 진행방향을 바꿈
                ball.setIntervals(ball.getXInterval(), -ball.getYInterval());
            } try {
                Thread.sleep(30);
            } catch (InterruptedException e) {

            }
        }
    }

}
