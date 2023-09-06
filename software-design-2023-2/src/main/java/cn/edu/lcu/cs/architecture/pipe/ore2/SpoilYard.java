package cn.edu.lcu.cs.architecture.pipe.ore2;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.PipedInputStream;

import static cn.edu.lcu.cs.util.ConsoleColor.FG_BLUE;

/**
 * 废料场
 * 仅有管道输入流
 */
public class SpoilYard extends Thread {
    private String color;
    private Ore.OreGrade grade;
    private Long amount; // 矿石数量
    private PipedInputStream pipedInputStream;

    public PipedInputStream getPipedInputStream() {
        return pipedInputStream;
    }

    public SpoilYard(Ore.OreGrade grade, String color) {
        this.color = color;
        this.grade = grade;
        this.amount = 0L;
        pipedInputStream = new PipedInputStream();
    }

    public SpoilYard() {
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
                amount++;
                System.out.println(color + amount + "\t" + grade + "\t" + ore.getSize());
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }
}
