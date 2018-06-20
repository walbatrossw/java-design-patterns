package exercise.p04_1_code;

import javax.swing.*;
import java.awt.*;

public class Field extends JPanel implements Runnable {

    private static final long serialVersionUID = 1L;
    private Ball[] balls;
    public Field(Ball[] balls) {
        this.balls = balls;
        setLayout(new FlowLayout());
    }

    public void paint(Graphics graphics) {
        graphics.clearRect(0, 0, BallFrame.WIDTH, BallFrame.HEIGHT);
        for (int i = 0; i < balls.length; i++) {
            graphics.setColor(balls[i].getColor());
            graphics.fillOval(balls[i].getX(), balls[i].getY(), Ball.SIZE, Ball.SIZE);
        }
    }

    @Override
    public void run() {
        while (true) {
            repaint();
            try {
                Thread.sleep(5);
            } catch (InterruptedException e) {

            }
        }
    }
}
