package cn.edu.lcu.cs.architecture.event.colorbtn;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.time.Instant;

public class ColorBtnGui {
    private JTextArea textArea;
    private JButton redButton;
    private JButton greenButton;
    private JButton blueButton;
    private JPanel btnPanel;
    private JPanel rootPanel;
    private JScrollPane scrollPane;
    private JTextField mouseCoor;

    public ColorBtnGui() {
        redButton.addActionListener(e -> {
            textArea.setForeground(Color.RED);
            updateText(e);
        });
        greenButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea.setForeground(Color.GREEN);
                updateText(e);
            }
        });
        blueButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea.setForeground(Color.BLUE);
                updateText(e);
            }
        });
        textArea.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                mouseCoor.setText("(" + e.getX() + "," + e.getY() + ")");
            }
        });
    }


    private void updateText(ActionEvent event) {
        String text = textArea.getText();
        text += event.getActionCommand() + "\t" + Instant.now() + "\n";
        textArea.setText(text);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("ColorBtnGui");
        frame.setContentPane(new ColorBtnGui().rootPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

}
