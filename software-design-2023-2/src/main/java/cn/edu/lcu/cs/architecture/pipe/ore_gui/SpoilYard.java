package cn.edu.lcu.cs.architecture.pipe.ore_gui;

import javax.swing.*;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.PipedInputStream;

/**
 * 废料场
 * 仅有管道输入流
 */
public class SpoilYard extends Thread {
    private Ore.OreGrade grade;
    private long amount;
    private JTextArea textArea;
    private PipedInputStream pipedInputStream;

    public PipedInputStream getPipedInputStream() {
        return pipedInputStream;
    }

    public SpoilYard(Ore.OreGrade grade, JTextArea textArea) {
        this.grade = grade;
        this.textArea = textArea;
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
                textArea.append(++amount + "\t" + ore.toString() + "\n");
                textArea.setCaretPosition(textArea.getText().length());
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }
}
