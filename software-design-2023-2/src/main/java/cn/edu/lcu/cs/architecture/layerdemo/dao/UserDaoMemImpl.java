package cn.edu.lcu.cs.architecture.layerdemo.dao;

import cn.edu.lcu.cs.architecture.layerdemo.entity.User;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * 数据访问对象，一般每个数据库表有对应的DAO对象。
 * 本实现类用内存中的列表模拟数据库。
 */
public class UserDaoMemImpl implements UserDao {
    // 用内存中的列表模拟数据库
    private static List<User> users = new ArrayList<>();

    // 静态初始化块，在类被加载时运行一次，为内存中的模拟列表准备数据
    static {
        int length = 100; // 元素个数
        Random random = new Random();
        // 生成 1945~2020 之间的 length 个随机整数，作为user对象生日属性的年份
        int[] years = random.ints(1949, 2020).limit(length).toArray();
        int[] months = random.ints(1, 12).limit(length).toArray();
        int[] days = random.ints(1, 28).limit(length).toArray();
        // 生成 length 个6位数的密码（整型，需要转化成字符串型）
        int[] passwords = random.ints(100000, 999999).limit(length).toArray();

        for (int i = 0; i < length; i++) {
            // 每次循环，生成一个用户，用随机生成的数据将其初始化，然后追加到用户列表中
            users.add(new User((long) (i + 1), "user" + (i + 1), "" + passwords[i], LocalDate.of(years[i], months[i], days[i])));
        }
        // 控制台输出所有数据
        users.forEach(System.out::println);
    }

    /**
     * 添加用户。
     *
     * @param user 入库前的用户
     * @return 入库后的用户，包含数据库自动生成的主键。
     */
    @Override
    public User add(User user) {
        if (user != null && !users.contains(user)) {
            // 将用户对象写入数据库，通常会自动生成一个自增长的主键。
            users.add(user);
            // 此处通常会将数据库自动生成的主键设置到user对象中并返回给上层。本例为演示代码，主键是由程序设定好的。
            return user;
        }
        return null;
    }

    /**
     * 判断指定的用户名是否已经被注册过了
     *
     * @param username
     * @return
     */
    @Override
    public boolean usernameExists(String username) {
        // anyMatch：判断的条件里，任意一个元素成功，返回true
        return users.stream().anyMatch(user -> user.getUsername().equals(username));
    }

    /**
     * 根据ID查询单个用户
     *
     * @param id
     * @return
     */
    @Override
    public User findById(Long id) {
        if (id != null) {
            return users.stream().filter(user -> user.getId() == id).findFirst().orElse(null);
        }
        return null;
    }

    /**
     * 根据用户名查询单个用户
     *
     * @param username
     * @return
     */
    @Override
    public User findByUsername(String username) {
        if (username != null) {
            return users.stream().filter(user -> user.getUsername().equals(username)).findFirst().orElse(null);
        }
        return null;
    }

    /**
     * @return 库中所有用户
     */
    @Override
    public List<User> findAll() {
        return users;
    }

    /**
     * 根据姓名模糊查询
     *
     * @param username
     * @return
     */
    @Override
    public List<User> findByUsernameLikely(String username) {
        if (username != null) {
            return users.stream().filter(user -> user.getUsername().contains(username)).collect(Collectors.toList());
        }
        return null;
    }

    /**
     * 更新用户信息。根据ID在列表中找到原来的数据，用新数据覆盖老数据。
     *
     * @param user
     * @return 更新记录的数量
     */
    @Override
    public int update(User user) {
        if (user != null && user.getId() != null) {
            User userToUpdated = findById(user.getId());
            userToUpdated.setUsername(user.getUsername());
            userToUpdated.setPassword(user.getPassword());
            userToUpdated.setBirthdate(user.getBirthdate());
            // 注册时间不能更新
            return 1; // 更新了一条数据
        }
        return 0;
    }

    /**
     * 根据ID删除记录
     *
     * @param id
     * @return 删除记录的数量
     */
    @Override
    public int deleteById(Long id) {
        User user = findById(id);
        if (user != null) {
            users.remove(user);
            return 1;
        } else {
            return 0;
        }

    }
}
