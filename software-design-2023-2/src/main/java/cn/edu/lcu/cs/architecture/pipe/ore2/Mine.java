package cn.edu.lcu.cs.architecture.pipe.ore2;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.PipedOutputStream;
import java.util.Random;

import static cn.edu.lcu.cs.util.ConsoleColor.DEFAULT;

/**
 * 矿井，源源不断地生产矿石
 */
public class Mine extends Thread {
    private Long amount; // 生产的矿石数量
    /**
     * 管道输出流
     */
    private PipedOutputStream pipedOutputStream;

    public PipedOutputStream getPipedOutputStream() {
        return pipedOutputStream;
    }

    public Mine() {
        pipedOutputStream = new PipedOutputStream();
        amount = 0L;
    }

    @Override
    public void run() {
        // 对象输出流，用于序列化矿石对象
        ObjectOutputStream objectOutputStream = null;
        // 如果只是想读写矿石的Double类型的size，可以用数据io流
//        DataOutputStream dataOutputStream = null;
        try {
            // 绑定对象输出流与管道输出流，序列化的对象将被写入管道
            objectOutputStream = new ObjectOutputStream(pipedOutputStream);
//            dataOutputStream = new DataOutputStream(pipedOutputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        while (true) { // 持续挖矿，挖出的矿石通过对象输出流写入管道
            Ore ore = dig(); // 挖矿，获取矿石
            amount++;
            System.out.println(DEFAULT + amount + "\t尺寸\t" + ore.getSize());
            try {
                objectOutputStream.writeObject(ore); // 将对象序列化为字节序列后写入管道流
                objectOutputStream.reset(); // 重置对象输出流，防止内存堆溢出
//                dataOutputStream.writeDouble(ore.getSize()); // 将浮点数通过数值输出流写入管道
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 挖矿
     *
     * @return 挖出的矿石
     */
    private Ore dig() {
        // 挖矿前休息500毫秒，别累着了。
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // 生成0~5之间的随机浮点，作为矿石的尺寸
        return new Ore(new Random().nextDouble() * 5);
    }
}
