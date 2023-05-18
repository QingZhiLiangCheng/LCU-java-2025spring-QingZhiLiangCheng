package cn.edu.lcu.cs.javaprogramming.dao;

import cn.edu.lcu.cs.javaprogramming.BaseTest;
import cn.edu.lcu.cs.javaprogramming.entity.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * TODO 这里写类的简短说明，如果没有就删除。
 * 2022/5/23 11:13
 *
 * @Author ling
 */
class UserDaoImplTest extends BaseTest {

    private UserDao userDao;

    @BeforeEach
    void before() {
        userDao = new UserDaoImpl();
    }

    @Test
    void findAll() {
        List<User> users = userDao.findAll();
        users.forEach(System.out::println);
    }

    @ParameterizedTest
    @CsvSource({"lisi,123"})
    void login(String username, String password) {
        List<User> users = userDao.findByUsernameAndPassword(username, password);
        User loggedUser = null;
        if (users.size()>0) {
            loggedUser = users.get(0);
        }

        System.out.println("loggedUser = " + loggedUser);
    }

    @ParameterizedTest
    @ValueSource(longs = {1})
    void findById(long id) {
        User user = userDao.findById(id);
        System.out.println("user = " + user);
        assertNotNull(user);
        assertEquals(user.getId(), id);
    }

    @Test
    void findByUsername() {
    }

    @Test
    void findByExample() {
    }

    @Test
    void save() {
        User user = User.builder()
                .username("zhaoliu")
                .password("123")
                .realName("赵六")
                .gender("男")
                .birthdate(LocalDate.of(2000, 1, 1))
                .build();
        int rowCount = userDao.save(user);
        assertEquals(1, rowCount);
        assertNotNull(user.getId());
    }

    @Test
    void deleteById() {
    }

    @Test
    void deleteByExample() {
    }

    @Test
    void update() {
    }

    /**
     * 演示正常登录与SQL注入登录
     *
     * @param username
     * @param password
     */
    @ParameterizedTest
    @CsvSource({"lisi,123456", "any' or '1'='1, any' or '1'='1", "lisi';#, any"})
    void findByUsernameAndPassword(String username, String password) {
        System.out.println("username = " + username);
        System.out.println("password = " + password);
        List<User> users = userDao.findByUsernameAndPassword(username, password);
        users.forEach(System.out::println);
    }

    /**
     * 演示正常登录与SQL注入登录
     *
     * @param username
     * @param password
     */
    @ParameterizedTest
    @CsvSource({"lisi,123456", "any' or '1'='1, any' or '1'='1", "lisi';#, any"})
    void findByUsernameAndPasswordSqlInjection(String username, String password) {
        System.out.println("username = " + username);
        System.out.println("password = " + password);
//        List<User> users = new UserDaoImpl().findByUsernameAndPasswordUnsafe(username, password);
//        users.forEach(System.out::println);
    }

}