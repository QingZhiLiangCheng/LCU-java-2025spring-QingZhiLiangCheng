package cn.edu.lcu.cs.architecture.mvc.usermanage.service;


import cn.edu.lcu.cs.architecture.mvc.usermanage.entity.User;

import java.util.List;

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

    /**
     * 依据ID删除用户
     * @param id
     * @return 删除记录的数量
     */
    int delete(Long id);

    /**
     * 更新用户
     *
     * @param user
     * @return 更新记录的数量
     */
    int update(User user);
}
