package exercise.p05;

public class HorizonalMoveStrategy extends DirectionsStrategy {
    @Override
    public void move(Ball ball) {
        ball.setIntervals(Ball.INTERVAL, 0);
        while (true) {
            ball.setX(ball.getX() + ball.getxInterval());
            if ((ball.getX() < 0 && ball.getxInterval() < 0) || ball.getX() + Ball.SIZE > BallFrame.WIDTH - 15 && ball.getxInterval() > 0) {
                ball.setIntervals(-ball.getxInterval(), 0);
            } try {
                Thread.sleep(30);
            } catch (InterruptedException e) {

            }
        }
    }
}
