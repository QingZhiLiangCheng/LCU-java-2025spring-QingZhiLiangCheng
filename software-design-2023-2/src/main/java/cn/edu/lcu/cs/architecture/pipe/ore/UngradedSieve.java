package cn.edu.lcu.cs.architecture.pipe.ore;

import java.io.*;

import static cn.edu.lcu.cs.util.ConsoleColor.FG_PURPLE;

/**
 * 次品矿石筛子
 */
public class UngradedSieve extends Thread {
    private PipedOutputStream pipedOutputStream;
    private PipedInputStream pipedInputStream;
    private Double meshSize; // 网眼大小

    public UngradedSieve() {
        pipedOutputStream = new PipedOutputStream();
        pipedInputStream = new PipedInputStream();
        meshSize = Ore.OreGrade.UNGRADED.getSizeThreshold();
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
            objectOutputStream = new ObjectOutputStream(pipedOutputStream);
            objectInputStream = new ObjectInputStream(pipedInputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        while (true) {
            try {
                Ore ore = (Ore) objectInputStream.readObject();
                if (ore.getSize() >= meshSize) {
                    System.out.println(FG_PURPLE + "次品矿石：" + ore.getSize());
                } else {
                    objectOutputStream.writeObject(ore);
                }
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

}
