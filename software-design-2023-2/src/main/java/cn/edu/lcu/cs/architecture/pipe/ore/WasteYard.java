package cn.edu.lcu.cs.architecture.pipe.ore;

import static cn.edu.lcu.cs.util.ConsoleColor.*;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.PipedInputStream;

/**
 * 废料场，仅有管道输入流
 * 将上游筛选剩下的矿石作为废料处理（显示）
 */
public class WasteYard extends Thread {
    private PipedInputStream pipedInputStream;

    public PipedInputStream getPipedInputStream() {
        return pipedInputStream;
    }

    public WasteYard() {
        pipedInputStream = new PipedInputStream();
    }

    @Override
    public void run() {
        ObjectInputStream objectInputStream = null;
        try {
            objectInputStream = new ObjectInputStream(pipedInputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        while (true) {
            try {
                Ore ore = (Ore) objectInputStream.readObject();
                System.out.println(FG_BLUE + "矿石废料：" + ore.getSize());
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }
}
