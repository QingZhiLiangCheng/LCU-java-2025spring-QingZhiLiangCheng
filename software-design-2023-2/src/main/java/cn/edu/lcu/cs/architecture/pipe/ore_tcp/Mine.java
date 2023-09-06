package cn.edu.lcu.cs.architecture.pipe.ore_tcp;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;

/**
 * 矿井，源源不断地生产矿石
 */
public class Mine {

    public void listen() throws IOException, InterruptedException {
        ServerSocket serverSocket = new ServerSocket(Constants.SOCKET_PORT_MINE);
        System.out.println("矿井服务等待下级筛子连接中……");
        Socket client = serverSocket.accept();
        String hostAddress = client.getLocalAddress().getHostAddress();
        int port = client.getPort();
        long amount = 0;
        System.out.printf("与 %s : %d 建立了连接……\n", hostAddress, port);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(client.getOutputStream());
        while (++amount < 100) {
            Ore ore = dig();
            System.out.println(amount + "\t" + ore);
            objectOutputStream.writeObject(ore);
            Thread.sleep(100);
        }
        objectOutputStream.close();
        client.close();
    }

    /**
     * 挖矿
     *
     * @return 挖出的矿石
     */
    private Ore dig() {
        // 生成0~5之间的随机浮点，作为矿石的尺寸
        return new Ore(new Random().nextDouble() * 5);
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        new Mine().listen();
    }
}
