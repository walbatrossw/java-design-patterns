package exercise.p05_1_code;

import javax.swing.*;
import java.awt.*;

public class Field extends JPanel implements Runnable {

    private JLabel jLabel;
    private String[] walkingImage = {"walk1.gif", "walk2.gif"};

    public Field() {
        setLayout(new BorderLayout());
        jLabel = new JLabel();
        jLabel.setIcon(new ImageIcon("./src/exercise/p05_1_code/img/walk1.gif"));
        add(jLabel, BorderLayout.CENTER);
    }

    public void run() {
        while (true) {
            String[] path = walkingImage;
            for (int i = 0; i < path.length; i++) {
                jLabel.setIcon(new ImageIcon("./src/exercise/p05_1_code/img/" + path[i]));
                try {
                    Thread.sleep(300);
                } catch (InterruptedException e) {

                }
            }
        }
    }
}
