package cn.edu.lcu.cs.javaprogramming.dao;

import cn.edu.lcu.cs.javaprogramming.db.DBUtil;
import cn.edu.lcu.cs.javaprogramming.entity.User;
import lombok.Cleanup;
import lombok.extern.java.Log;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Log
public class UserDaoImpl implements UserDao {
    @Override
    public List<User> findAll() {
        List<User> users = new ArrayList<>();

        try {
            @Cleanup
            Connection connection = DBUtil.getConnection();
            @Cleanup
            Statement statement = connection.createStatement();
            // statement.executeQuery(sql)，每次执行sql，都是现场编译再运行，效率低。
            @Cleanup
            ResultSet resultSet = statement.executeQuery("select * from user");
            while (resultSet.next()) {
                User user = dump(resultSet);
                users.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return users;
    }

    @Override
    public User findById(Long id) {
        return null;
    }

    @Override
    public List<User> findByUsername(String username) {
        return null;
    }

    @Override
    public List<User> findByExample(User example) {
        return null;
    }

    @Override
    public int save(User user) {
        int rowCount = 0;
        try {
            @Cleanup
            Connection connection = DBUtil.getConnection();
            String sql = "insert into user(username, password, real_name, gender, birthdate) values (?,?,?,?,?)";
            // 创建预编译语句时，指定返回数据库生成的主键
            @Cleanup
            PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, user.getUsername());
            statement.setString(2, user.getPassword());
            statement.setString(3, user.getRealName());
            statement.setString(4, user.getGender());
            statement.setDate(5, Date.valueOf(user.getBirthdate()));
            rowCount = statement.executeUpdate();
            // 获取数据库生成的主键
            @Cleanup
            ResultSet generatedKeys = statement.getGeneratedKeys();
            if (generatedKeys.next()) {
                long id = generatedKeys.getLong(1);
                user.setId(id);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return rowCount;
    }

    @Override
    public int deleteById(Long id) {
        int rowCount = 0;
        try {
            @Cleanup
            Connection connection = DBUtil.getConnection();
            String sql = "delete from user where id=?";
            @Cleanup
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setLong(1, id);
            rowCount = statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return rowCount;
    }

    @Override
    public int deleteByExample(User example) {
        return 0;
    }

    @Override
    public int update(User user) {
        return 0;
    }

    @Override
    public List<User> findByUsernameAndPassword(String username, String password) {
        List<User> users = new ArrayList<>();

        try {
            @Cleanup
            Connection connection = DBUtil.getConnection();
            String sql = "select * from user where username=? and password=?";
            log.info(sql);
            @Cleanup
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, username);
            statement.setString(2, password);
            @Cleanup
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                User user = dump(resultSet);
                users.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return users;
    }

    /**
     * 不安全的条件查询。
     * 因为查询条件是通过字符串拼接生成的，可能会被SQL注入攻击。
     *
     * @param username
     * @param password
     * @return
     */
    public List<User> findByUsernameAndPasswordUnsafe(String username, String password) {
        List<User> users = new ArrayList<>();

        try {
            @Cleanup
            Connection connection = DBUtil.getConnection();
            @Cleanup
            Statement statement = connection.createStatement();
            String sql = "select * from user where username='" + username + "' and password='" + password + "'";
            log.info(sql);
            @Cleanup
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                User user = dump(resultSet);
                users.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return users;
    }

    private User dump(ResultSet resultSet) throws SQLException {
        User user = User.builder()
                .id(resultSet.getLong(1))
                .username(resultSet.getString("username"))
                .password(resultSet.getString("password"))
                .gender(resultSet.getString("gender"))
                .realName(resultSet.getString("real_name"))
                .birthdate(resultSet.getDate("birthdate").toLocalDate())
                .build();
        return user;
    }
}