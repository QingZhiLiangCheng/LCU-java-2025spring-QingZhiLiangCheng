package cn.edu.lcu.cs.architecture.pipe.ore;

import lombok.Getter;

import java.io.*;

import static cn.edu.lcu.cs.architecture.pipe.ore.Ore.OreGrade.*;
import static cn.edu.lcu.cs.util.ConsoleColor.*;

/**
 * 特级矿石筛子。
 * 持续从上游管道（矿井）获取序列化后的矿石对象，反序列化为内存中的对象。
 * 判断当前矿石对象的品级，将特级矿石保留并处理（输出），将剩余矿石发送到下游管道处理。
 */
@Getter
public class SpecialGradeSieve extends Thread {
    private PipedOutputStream pipedOutputStream; // 管道输出流
    private PipedInputStream pipedInputStream; // 管道输入流
    private Double meshSize; // 网眼大小

    public SpecialGradeSieve() {
        pipedOutputStream = new PipedOutputStream();
        pipedInputStream = new PipedInputStream();
        meshSize = SPECIAL.getSizeThreshold();
    }

    @Override
    public void run() {
        // 将管道IO流与对象IO流绑定

        try (ObjectInputStream objectInputStream = new ObjectInputStream(pipedInputStream);
             ObjectOutputStream objectOutputStream = new ObjectOutputStream(pipedOutputStream)) {
            // 持续从上游管道（矿井）读取矿石对象，筛选特级矿石，剩余矿石转发到下游管道。
            while (true) {
                try {
                    // 从对象输入流中读取数据，反序列化为内存中的矿石对象
                    Ore ore = (Ore) objectInputStream.readObject();
                    if (ore.getSize() >= meshSize) {
                        // 筛选特级矿石并输出
                        System.out.println(FG_RED + "特级矿石：" + ore.getSize());
                    } else {
                        // 剩余矿石转发到下游管道
                        objectOutputStream.writeObject(ore);
                    }
                } catch (IOException | ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
