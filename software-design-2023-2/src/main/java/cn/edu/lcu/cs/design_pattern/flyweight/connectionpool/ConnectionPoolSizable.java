package cn.edu.lcu.cs.design_pattern.flyweight.connectionpool;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 模拟数据库连接池，容量可调。
 *
 * @author ling
 */
public class ConnectionPoolSizable {
    private static Queue<Connection> pool = new LinkedList<Connection>();

    private int poolSize = 15;

    /**
     * 一次性创建多个连接，并添加到连接池中。
     *
     * @param poolSize
     * @param url
     * @param username
     * @param password
     */
    public ConnectionPoolSizable(String url, String username, String password, int poolSize) {
        this.poolSize = poolSize;
        for (int i = 1; i <= poolSize; i++) {
            //Connection connection = new Connection("jdbc:mysql://localhost/goodedu?characterEncoding=utf-8&useSSL=false", "root", "root", "连接" + i);
            Connection connection = new Connection(url, username, password, "连接" + i);
            // 添加元素到队列，不抛异常
            pool.offer(connection);
        }
    }

    /**
     * 从连接池中获取连接并返回
     *
     * @return
     */
    public static Connection open() {
        return getConnection();
    }

    /**
     * 从连接池中获取连接并返回
     *
     * @return
     */
    public static Connection getConnection() {
        return pool.poll(); // 队首元素出队列，不抛异常
//        return pool.remove(); // 队首元素出队列，可能抛异常
    }

    /**
     * 把连接归还到连接池
     */
    public static void close(Connection connection) {
        pool.offer(connection);
    }
}
