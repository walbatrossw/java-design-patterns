package exercise.p04_1_code;

import javax.swing.*;
import java.awt.*;

// 전체 프레임 클래스
public class BallFrame extends JFrame {

    private static final long serialVersionUID = 1L;
    public static final int WIDTH = 500;    // 너비
    public static final int HEIGHT = 400;   // 높이
    private Field field;

    // 생성자
    public BallFrame(Ball[] balls) {
        super("Balls");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        field = new Field(balls);
        Thread thread = new Thread(field);
        thread.start();

        add(field, BorderLayout.CENTER);
        setSize(WIDTH, HEIGHT);
        setVisible(true);
    }

}
