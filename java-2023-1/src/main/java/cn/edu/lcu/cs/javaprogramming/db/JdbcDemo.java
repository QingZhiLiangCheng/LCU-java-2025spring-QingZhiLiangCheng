package cn.edu.lcu.cs.javaprogramming.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * 数据库工具类
 * <p>
 * 2022/5/22 16:14
 *
 * @Author ling
 */
public class JdbcDemo {
    private static final String DRIVER_NAME = "com.mysql.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost/goodedu?characterEncoding=utf-8&useSSL=false";
    private static final String USER = "root";
    private static final String PASSWORD = "root";


    /**
     * 仅演示用，
     * @param args
     */
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        // jdbc查询的流程
        // 1、加载数据库驱动
        Class.forName(DRIVER_NAME);

        // 2、获取数据库连接
        Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
        System.out.println("connection = " + connection);

        // 3、创建statement语句
        // 4、执行查询
        // 5、处理结果集


        // 6、关闭各种资源，关闭顺序与打开顺序相反。
        connection.close();

    }

}