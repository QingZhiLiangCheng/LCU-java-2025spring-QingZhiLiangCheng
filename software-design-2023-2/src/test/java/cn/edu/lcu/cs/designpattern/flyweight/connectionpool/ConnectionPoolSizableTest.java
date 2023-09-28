package cn.edu.lcu.cs.designpattern.flyweight.connectionpool;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

/**
 * @author ling
 * @date 2022/9/11 23:16
 */
class ConnectionPoolSizableTest {

    @ParameterizedTest
    @CsvSource({"jdbc:mysql://localhost/goodedu?characterEncoding=utf-8&useSSL=false, root, root, 12"})
    void getConnection(String url, String username, String password, int poolSize) throws Exception {
        ConnectionPoolSizable pool = new ConnectionPoolSizable(url, username, password, poolSize);
        System.out.println("pool.getConnection() = " + pool.getConnection());
    }
}