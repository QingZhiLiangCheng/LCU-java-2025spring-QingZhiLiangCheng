package cn.edu.lcu.cs.architecture.pipe.ore;

import lombok.Getter;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.PipedOutputStream;
import java.util.Random;

import static cn.edu.lcu.cs.util.ConsoleColor.DEFAULT;

/**
 * 矿井，源源不断地生产矿石。
 * 独立线程。
 */
@Getter
public class Mine extends Thread {
    /**
     * 管道输出流
     */
    private PipedOutputStream pipedOutputStream;

    public Mine() {
        pipedOutputStream = new PipedOutputStream();
    }

    @Override
    public void run() {
        // 对象输出流，用于序列化矿石对象。
        // 绑定对象输出流与管道输出流，序列化的对象将被写入管道。
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(pipedOutputStream)) {
            // 持续挖矿，挖出的矿石通过对象输出流写入管道。
            while (true) {
                // 挖矿，获取矿石
                Ore ore = dig();
                System.out.println(DEFAULT + "挖矿尺寸：" + ore.getSize());
                try {
                    // 向对象输出流写入序列化的对象。
                    // 对象输出流与管道输出流绑定，所以序列化的对象写入到管道。
                    objectOutputStream.writeObject(ore);
                    // 重置对象输出流，防止内存堆溢出
                    objectOutputStream.reset();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 挖矿，随机挖出矿石。
     *
     * @return 挖出的矿石
     */
    private Ore dig() {
        // 挖矿前休息若干毫秒，别累着了。
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // 生成0~5之间的随机浮点，作为矿石的尺寸
        return new Ore(new Random().nextDouble() * 5);
    }
}
