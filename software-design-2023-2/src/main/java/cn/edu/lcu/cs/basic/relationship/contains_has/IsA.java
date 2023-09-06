package cn.edu.lcu.cs.basic.relationship.contains_has;

import javax.swing.*;

/**
 * 使用继承而不是聚合
 */
public class IsA extends JFrame {

    public IsA () {
        setTitle("Is A Demo");
        // 设置关闭窗口时的默认操作
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // 设置窗口尺寸
        setSize(250, 150);
        // 展示JFrame容器窗口
        setVisible(true);
    }

    public static void main(String[] args) {
        IsA frame = new IsA();
    }
}
