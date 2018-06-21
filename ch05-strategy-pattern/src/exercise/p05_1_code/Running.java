package exercise.p05_1_code;

import javax.swing.*;
import java.awt.*;

public class Running extends JFrame {
    private Field field;

    public Running() {
        super("Running");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        field = new Field();
        add(field, BorderLayout.CENTER);

        setSize(500, 500);
        setVisible(true);
        Thread thread = new Thread(field);
        thread.start();
    }
}
