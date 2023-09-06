package cn.edu.lcu.cs.architecture.layerdemo.service;

import cn.edu.lcu.cs.architecture.layerdemo.entity.User;

import java.util.List;

/**
 * 用户功能的服务类（业务类）
 */
public interface UserService {
    /**
     * 新用户注册
     *
     * @param user
     * @return 注册成功之后的用户对象，包含数据库自动生成的主键
     */
    User register(User user);

    User findById(Long id);

    /**
     * 根据用户名及密码进行登录确证
     *
     * @param username
     * @param password
     * @return 如果登录成功，返回用户对象；如果登录失败，返回null。
     */
    User login(String username, String password);

    /**
     * @return 库中所有用户
     */
    List<User> findAll();

    /**
     * 根据姓名模糊查询
     *
     * @param username
     * @return
     */
    List<User> findByUsernameLikely(String username);
}
