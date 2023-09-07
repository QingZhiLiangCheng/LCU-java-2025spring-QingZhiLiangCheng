package cn.edu.lcu.cs.designpattern.observer.gui;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

/**
 * 观察者窗口，一直
 */
public class ObservingFrame {

    public static void main(String [] args) {
        new ObservingFrame();
    }
	
    public ObservingFrame() {
	
        JFrame frame = new JFrame("Observing Frame");
        final JLabel label = new JLabel("Observing...");
        label.setFont(new Font("Dialog", Font.PLAIN, 18));
        frame.add(label);
        frame.getRootPane().setBorder(new EmptyBorder(10, 10, 10, 10));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(250, 150);
        frame.setLocation(200, 200);
        frame.setVisible(true);

        // 创建一个Bean实例
        MessageBean bean = new MessageBean();
        // 添加属性改变监听器
        bean.addPropertyChangeListener(e ->
            label.setText((String) e.getNewValue())
        );

        // Open the second window
        new ObservableFrame(bean);
    }
}
