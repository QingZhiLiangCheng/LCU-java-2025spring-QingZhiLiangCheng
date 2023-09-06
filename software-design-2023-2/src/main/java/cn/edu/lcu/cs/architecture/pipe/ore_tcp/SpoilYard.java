package cn.edu.lcu.cs.architecture.pipe.ore_tcp;

import javax.swing.*;
import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.PipedInputStream;
import java.net.Socket;

import static cn.edu.lcu.cs.architecture.pipe.ore_tcp.Constants.*;

/**
 * 废料场
 * 仅有管道输入流
 */
public class SpoilYard {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        new SpoilYard().read();
    }

    private void read() throws IOException  {
        long amount = 0;
        System.out.println("努力与上游建立连接……");
        Socket socket = new Socket(HOST, SOCKET_PORT_MINE);
        System.out.printf("与 %s : %d 的连接已建立\n", HOST, SOCKET_PORT_MINE);
        ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());
        while (true) {
            Ore ore = null;
            try {
                ore = (Ore) objectInputStream.readObject();
            } catch (EOFException e) {
                System.out.println("数据传输结束");
                break;
            } catch (ClassNotFoundException e) {
                System.out.println("数据格式错误");
            }
            System.out.println(++amount + "\t" + ore);
        }
        objectInputStream.close();
        socket.close();

    }
}
