package cn.edu.lcu.cs.designpattern.flyweight.connectionpool;

import org.junit.jupiter.api.Test;

class ConnectionPoolTest {
    ConnectionPool pool = ConnectionPool.getInstance();

    /**
     * 获取连接后不及时关闭（归还），可能耗光资源，导致后续代码获取不到资源
     */
    @Test
    void testOpenWithoutClose() {
        for (int i = 0; i < 20; i++) {
            Connection connection = pool.open();
            System.out.println(connection);
        }
    }

    /**
     * 获取连接后及时关闭（归还），后续代码可持续获取连接
     */
    @Test
    void testOpenWithClose() {

        for (int i = 0; i < 20; i++) {
            Connection connection = pool.open();
            System.out.println(connection);
            pool.close(connection);
        }
    }

    @Test
    void close() {
    }
}