package cn.edu.lcu.cs.designpattern.state.trafficlight.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Timer;

public class TrafficLightGUI extends JDialog {
    private TrafficLight light;
    private Timer timer;
    private JPanel contentPane;
    private JButton buttonStart;
    private JButton buttonExit;
    private JProgressBar countdownProgress;
    private JLabel countdownLabel;

    public TrafficLightGUI() {
        light = new TrafficLight();
        resetLight();
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonStart);

        buttonStart.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onStart();
            }
        });

        buttonExit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onExit();
            }
        });

        // call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onExit();
            }
        });

        // call onCancel() on ESCAPE
        contentPane.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onExit();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
    }

    /**
     * 当颜色状态变化后，重置某些组件的颜色与初值。
     */
    private void resetLight() {
        Color color = null;
        switch (light.getColor()) {
            case "红色":
                color = new Color(255, 0, 0);
                break;
            case "绿色":
                color = new Color(0, 255, 0);
                break;
            case "黄色":
                color = new Color(255, 255, 0);
                break;
        }
        countdownProgress.setMinimum(0);
        countdownProgress.setMaximum(light.getMaxCountdown());
        countdownProgress.setForeground(color);

        countdownLabel.setForeground(color);
    }

    /**
     * 当点击开始按钮后，启动另外一个线程进行循环倒计时。
     * 必须启动另外一个线程。
     */
    private void onStart() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    // display
                    int countdown = light.getCountdown();
                    countdownLabel.setText("" + countdown);
                    countdownProgress.setValue(countdown);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    // 如果颜色状态变更，重置图形组件的一些属性。
                    if (light.change()) {
                        resetLight(); // 重置
                    }
                }
            }
        }).start();
    }

    private void onExit() {
        // add your code here if necessary
        dispose();
    }

    public static void main(String[] args) {
        TrafficLightGUI dialog = new TrafficLightGUI();
        dialog.setTitle("红绿灯");
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}
