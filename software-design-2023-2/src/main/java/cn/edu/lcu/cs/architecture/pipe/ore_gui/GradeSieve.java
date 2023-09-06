package cn.edu.lcu.cs.architecture.pipe.ore_gui;


import javax.swing.*;
import java.io.*;

/**
 * 选矿筛子
 */
public class GradeSieve extends Thread {
    protected PipedOutputStream pipedOutputStream; // 管道输出流
    protected PipedInputStream pipedInputStream; // 管道输入流
    private Ore.OreGrade grade; // 选矿级别
    private long amount;
    private JTextArea textArea;

    public GradeSieve(Ore.OreGrade grade, JTextArea textArea) {
        this.grade = grade;
        this.textArea = textArea;
        pipedOutputStream = new PipedOutputStream();
        pipedInputStream = new PipedInputStream();
    }

    public PipedOutputStream getPipedOutputStream() {
        return pipedOutputStream;
    }

    public PipedInputStream getPipedInputStream() {
        return pipedInputStream;
    }

    @Override
    public void run() {
        ObjectOutputStream objectOutputStream = null;
        ObjectInputStream objectInputStream = null;
        try {
            // 将管道IO流与对象IO流绑定
            objectOutputStream = new ObjectOutputStream(pipedOutputStream);
            objectInputStream = new ObjectInputStream(pipedInputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 持续从上游管道（矿井）读取矿石对象，筛选特级矿石，剩余矿石转发到下游管道。
        while (true) {
            try {
                // 从对象输入流中读取数据，反序列化为内存中的矿石对象
                Ore ore = (Ore) objectInputStream.readObject();
                if (ore.getSize() >= grade.getSizeThreshold()) {
                    // 筛选矿石并输出
                    textArea.append(++amount + "\t" + ore.toString() + "\n");
                    textArea.setCaretPosition(textArea.getText().length());
                } else {
                    // 剩余矿石转发到下游管道
                    objectOutputStream.writeObject(ore);
                }
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }
}
