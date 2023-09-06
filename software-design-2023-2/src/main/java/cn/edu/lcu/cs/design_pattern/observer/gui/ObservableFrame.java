package cn.edu.lcu.cs.design_pattern.observer.gui;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

class ObservableFrame {

    /**
     * 累积点击数量
     */
    private int clicks;

    public ObservableFrame(MessageBean bean) {

        JFrame frame = new JFrame("ObservableFrame");
        JLabel label = new JLabel("Click anywhere to fire a property change event");
        label.setFont(new Font("Dialog", Font.PLAIN, 18));
        frame.add(label);
        frame.getRootPane().setBorder(new EmptyBorder(10, 10, 10, 10));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(450, 150);
        frame.setLocation(600, 200);
        frame.setVisible(true);

        // 为当前窗口添加鼠标单击事件监听器
        // 这个例子既有swing的事件处理，也有PropertyChangeListener支持的事件处理，容易让人迷惑。
        frame.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                String data = "Click-count [" + ++clicks + "]";
                // 修改Bean的属性，触发这个Bean上的属性修改事件
                bean.setMessage(data);
            }
        });
    }
}