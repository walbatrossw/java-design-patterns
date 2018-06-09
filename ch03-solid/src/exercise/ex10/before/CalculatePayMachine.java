package exercise.ex10.before;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculatePayMachine extends Frame implements ActionListener, DocumentListener {

    private JLabel workingHoursLabel = new JLabel("Working Hours = ", Label.RIGHT);
    private JLabel overTimeHoursLabel = new JLabel("Overtime Hours = ", Label.RIGHT);
    private JLabel payAmountLabel = new JLabel("Pay Amount = ", Label.RIGHT);

    private JTextField tfWorkingHours = new JTextField();
    private JTextField tfOvertimeHours = new JTextField();
    private JTextField tfResult = new JTextField();

    private JButton calcButton = new JButton("Calculate");
    private JButton resetButton = new JButton("Reset");
    private JButton end = new JButton("Stop");

    public CalculatePayMachine() {
        super("Payment Calculation");
        this.init();
        this.start();
        this.setSize(500, 250);
        this.setVisible(true);
    }

    private void init() {
        this.setLayout(new GridLayout(5, 1));

        Panel panel = new Panel(new BorderLayout());
        panel.add("West", workingHoursLabel);
        panel.add("Center", tfWorkingHours);
        this.add(panel);

        Panel panel1 = new Panel(new BorderLayout());
        panel1.add("West", overTimeHoursLabel);
        panel1.add("Center", tfOvertimeHours);
        this.add(panel1);

        Panel panel2 = new Panel(new FlowLayout(FlowLayout.CENTER));
        panel2.add(calcButton);
        this.add(panel2);

        Panel panel3 = new Panel(new BorderLayout());
        panel3.add("West", payAmountLabel);
        panel3.add("Center", tfResult);
        this.add(panel3);

        Panel panel4 = new Panel(new FlowLayout(FlowLayout.RIGHT));
        panel4.add(resetButton);
        panel4.add(end);
        this.add(panel4);
    }

    private void start() {
        calcButton.addActionListener(this);
        resetButton.addActionListener(this);

        tfWorkingHours.getDocument().addDocumentListener(this);
        tfOvertimeHours.getDocument().addDocumentListener(this);

        end.addActionListener(this);

        calcButton.setEnabled(false);
        resetButton.setEnabled(false);
    }

    public boolean isDataEntered() {
        if (tfWorkingHours.getText().trim().length() == 0 ||
                tfOvertimeHours.getText().trim().length() == 0) {
            return false;
        }
        return true;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == end) {
            System.exit(0);
        }

        if (e.getSource() == resetButton) {
            tfWorkingHours.setText("");
            tfOvertimeHours.setText("");
            tfWorkingHours.requestFocus();
            tfResult.setText("");
            resetButton.setEnabled(false);
            return;
        }

        if (e.getSource() == calcButton) {
            int x = 0;
            try {
                x = Integer.parseInt(tfWorkingHours.getText().trim());
            } catch (NumberFormatException ee) {
                tfWorkingHours.setText("");
                tfWorkingHours.requestFocus();
                return;
            }

            int y = 0;
            try {
                y = Integer.parseInt(tfOvertimeHours.getText().trim());
            } catch (NumberFormatException ee) {
                tfOvertimeHours.setText("");
                tfOvertimeHours.requestFocus();
                return;
            }

            int payAmount = 0;
            payAmount = 10 * x + 15 * y;

            tfResult.setText(String.valueOf(payAmount));
            resetButton.setEnabled(true);
        }
    }

    @Override
    public void insertUpdate(DocumentEvent e) {
        checkData();
    }

    @Override
    public void removeUpdate(DocumentEvent e) {
        checkData();
    }

    @Override
    public void changedUpdate(DocumentEvent e) {
        checkData();
    }

    private void checkData() {
        calcButton.setEnabled(isDataEntered());
    }

}
