package cn.edu.lcu.cs.designpattern.flyweight.connectionpool;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 模拟数据库连接池，存储事先创建好的若干个数据库连接。
 * 数据库连接池本身用单例模式设计。
 *
 * @author ling
 */
public class ConnectionPool {
    /**
     * 连接池初始最大容量
     */
    private final static int MAX_COUNT = 15;
    /**
     * 连接池，存储事先创建好的数据库连接。
     */
    private static Queue<Connection> pool = new LinkedList<Connection>();

    /**
     * 创建若干连接到连接池中，仅在类加载时执行一次
     */
    static {
        for (long i = 1; i <= MAX_COUNT; i++) {
            Connection connection = new Connection("jdbc:mysql://localhost/goodedu?characterEncoding=utf-8&useSSL=false", "root", "root", "连接" + i);
//            pool.add(connection); // 添加元素到队列，可能抛异常
            pool.offer(connection); // 添加元素到队列，不抛异常
        }
    }

    private static final ConnectionPool INSTANCE = new ConnectionPool();

    public static ConnectionPool getInstance() {
        return INSTANCE;
    }


    /**
     * 从连接池中获取连接并返回
     *
     * @return
     */
    public Connection open() {
        return getConnection();
    }

    /**
     * 从连接池中获取连接并返回
     *
     * @return
     */
    public Connection getConnection() {
        return pool.poll(); // 队首元素出队列，不抛异常
//        return pool.remove(); // 队首元素出队列，可能抛异常
    }

    /**
     * 把连接归还到连接池
     */
    public void close(Connection connection) {
        pool.offer(connection);
    }
}
