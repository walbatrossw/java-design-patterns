package exercise.p04_1_code;

import java.awt.*;

// 공 클래스
public class Ball extends Thread {

    public static final int SIZE = 20;      // 크기
    public static final int INTERVAL = 10;  // 간격
    private int x, y;                       // x, y 좌표
    private int xInterval, yInterval;       // x, y 간격
    private DirectionsStrategy directionsStrategy;  // 방향 전략
    private DrawStrategy drawStrategy;              // 그리기 전략
    private Color color;                            // 색

    public Ball(int x, int y) {
        this.x = x;
        this.y = y;
        this.xInterval = xInterval;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getXInterval() {
        return xInterval;
    }

    public int getYInterval() {
        return yInterval;
    }

    public void setIntervals(int xInterval, int yInterval) {
        this.xInterval = xInterval;
        this.yInterval = yInterval;
    }

    public void setDirectionsStrategy(DirectionsStrategy directionsStrategy) {
        this.directionsStrategy = directionsStrategy;
    }

    public void setDrawStrategy(DrawStrategy drawStrategy) {
        this.drawStrategy = drawStrategy;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public void draw() {
        drawStrategy.draw(this);
    }

    public void move() {
        directionsStrategy.move(this);
    }

    public void run() {
        draw();
        move();
    }

}
