package cn.edu.lcu.cs.architecture.pipe.ore_gui;

import javax.swing.*;
import java.awt.event.*;
import java.io.IOException;

public class OreSieveDlg extends JDialog {
    private JPanel contentPane;
    private JButton buttonStart;
    private JButton buttonExit;
    private JTextArea mineText;
    private JTextArea specialGradeText;
    private JTextArea oneGradeText;
    private JTextArea twoGradeText;
    private JTextArea ungradedText;
    private JTextArea spoilYardText;
    private JButton buttonPause;
    private JButton buttonResume;
    private Mine mine;

    public OreSieveDlg() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonStart);

        buttonStart.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onStart();
                buttonStart.setEnabled(false);
                buttonPause.setEnabled(true);
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
        buttonPause.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onPause();
                buttonPause.setEnabled(false);
                buttonResume.setEnabled(true);
            }
        });
        buttonResume.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onResume();
                buttonResume.setEnabled(false);
                buttonPause.setEnabled(true);
            }
        });
    }

    private void onResume() {
        mine.resume();
    }

    private void onPause() {
        mine.suspend();
    }

    private void onStart() {
        // 创建数据源及各级管道过滤器
        // 矿井
        mine = new Mine(mineText);
        GradeSieve specialGradeSieve = new GradeSieve(Ore.OreGrade.SPECIAL, specialGradeText); // 特级矿石筛子
        GradeSieve gradeOneSieve = new GradeSieve(Ore.OreGrade.GRADE_ONE, oneGradeText); // 一级矿石筛子
        GradeSieve gradeTwoSieve = new GradeSieve(Ore.OreGrade.GRADE_TWO, twoGradeText); // 二级矿石筛子
        GradeSieve ungragedSieve = new GradeSieve(Ore.OreGrade.UNGRADED, ungradedText); // 次品矿石筛子
        SpoilYard spoilYard = new SpoilYard(Ore.OreGrade.WASTE, spoilYardText); // 废料场
        try {
            // 分别将上游过滤器管道输出流与下游过滤器的管道输入流连接起来
            mine.getPipedOutputStream().connect(specialGradeSieve.getPipedInputStream());
            specialGradeSieve.getPipedOutputStream().connect(gradeOneSieve.getPipedInputStream());
            gradeOneSieve.getPipedOutputStream().connect(gradeTwoSieve.getPipedInputStream());
            gradeTwoSieve.getPipedOutputStream().connect(ungragedSieve.getPipedInputStream());
            ungragedSieve.getPipedOutputStream().connect(spoilYard.getPipedInputStream());
            // 启动各个过滤器线程，持续生产矿石并输送到管道中的各级过滤器上
            mine.start();
            specialGradeSieve.start();
            gradeOneSieve.start();
            gradeTwoSieve.start();
            ungragedSieve.start();
            spoilYard.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void onExit() {
        // add your code here if necessary
        dispose();
    }

    public static void main(String[] args) {
        OreSieveDlg dialog = new OreSieveDlg();
        dialog.setTitle("选矿流水线");
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}
