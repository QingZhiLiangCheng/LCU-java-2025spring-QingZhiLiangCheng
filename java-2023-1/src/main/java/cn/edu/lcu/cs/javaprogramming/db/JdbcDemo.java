package cn.edu.lcu.cs.javaprogramming.db;

import cn.edu.lcu.cs.javaprogramming.oop.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

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

        List<Student> students = new ArrayList<>();

        // 5、处理结果集
        while (resultSet.next()) {
            Student student = new Student();
            student.setId(resultSet.getLong("id"));
            student.setStudentNo(resultSet.getString("student_no"));
            student.setName(resultSet.getString("student_name"));
            student.setGender(resultSet.getString("gender"));
            Date birthdate = resultSet.getDate("birthdate");
            student.setBirthDate(birthdate==null ? null : birthdate.toLocalDate());
            students.add(student);
        }


        // 6、关闭各种资源，关闭顺序与打开顺序相反。
        resultSet.close();
        statement.close();
        connection.close();


        System.out.println(students);

    }

}