package cn.edu.lcu.cs.basic.relationship.contains_has;

import javax.swing.*;

/**
 * 使用聚合关系
 */
public class ContainsA {
    private JFrame frame;

    public ContainsA() {
        frame = new JFrame("Contains A Demo");
        // 设置关闭窗口时的默认操作
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // 设置窗口尺寸
        frame.setSize(250, 150);
        // 展示JFrame容器窗口
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new ContainsA();
    }
}
