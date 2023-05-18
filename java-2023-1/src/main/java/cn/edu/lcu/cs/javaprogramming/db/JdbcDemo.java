package cn.edu.lcu.cs.javaprogramming.db;

import java.sql.*;

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

        // 如果connection非空，说明获取连接成功
        // connection = com.mysql.jdbc.JDBC4Connection@5d624da6
//        System.out.println("connection = " + connection);

        // 3、创建statement语句
        Statement statement = connection.createStatement();


        // 4、执行查询
        String sql = "SELECT * FROM student";
        ResultSet resultSet = statement.executeQuery(sql);

        // 5、处理结果集
        while (resultSet.next()) {
            // 从当前行中获取各列的数据
            long id = resultSet.getLong(1);
            long id1 = resultSet.getLong("id");
            System.out.println("id = " + id);
            System.out.println("id1 = " + id1);
        }


        // 6、关闭各种资源，关闭顺序与打开顺序相反。
        resultSet.close();
        statement.close();
        connection.close();

    }

}