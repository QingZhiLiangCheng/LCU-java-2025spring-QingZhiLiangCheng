package cn.edu.lcu.cs.architecture.pipe.ore2;


import java.io.*;

/**
 * 选矿筛子
 */
public class GradeSieve extends Thread {
    protected PipedOutputStream pipedOutputStream; // 管道输出流
    protected PipedInputStream pipedInputStream; // 管道输入流
    private Ore.OreGrade grade; // 选矿级别
    private String color; // 输出颜色
    private Long amount; // 矿石数量

    public GradeSieve(Ore.OreGrade grade, String color) {
        this.grade = grade;
        this.color = color;
        this.amount = 0L;
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
        // 持续从上游管道（矿井）读取矿石对象，筛选某级矿石，剩余矿石转发到下游管道。
        while (true) {
            try {
                // 从对象输入流中读取数据，反序列化为内存中的矿石对象
                Ore ore = (Ore) objectInputStream.readObject();
                if (ore.getSize() >= grade.getSizeThreshold()) {
                    // 筛选矿石并输出
                    amount++;
                    System.out.println(color + amount + "\t" + grade + "\t" + ore.getSize());
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
