package cn.edu.lcu.cs.javaprogramming.oop.innerclass;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * 在GUI编程中，内部类常用于实现事件监听器。例如，在Swing或JavaFX中，可以使用匿名内部类来处理按钮点击事件。
 *
 * @author ling
 */
public class ButtonExample {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Button Example");
        JButton button = new JButton("Click Me");

        // 使用匿名内部类实现ActionListener
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(frame, "Button Clicked!");
            }
        });

        frame.add(button);
        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
