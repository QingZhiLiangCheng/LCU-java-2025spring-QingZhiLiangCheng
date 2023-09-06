package cn.edu.lcu.cs.architecture.mvc.usermanage.dao;

import cn.edu.lcu.cs.architecture.mvc.usermanage.entity.User;

import java.util.List;

public interface UserDao {
    /**
     * 添加用户。
     *
     * @param user 入库前的用户
     * @return 入库后的用户，包含数据库自动生成的主键。
     */
    User add(User user);

    /**
     * 判断指定的用户名是否已经被注册过了
     *
     * @param username
     * @return
     */
    boolean usernameExists(String username);

    /**
     * 根据ID查询单个用户
     *
     * @param id
     * @return
     */
    User findById(Long id);

    /**
     * 根据用户名查询单个用户
     *
     * @param username
     * @return
     */
    User findByUsername(String username);

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
     * 更新用户信息。根据ID在列表中找到原来的数据，用新数据覆盖老数据。
     *
     * @param user
     * @return 更新记录的数量
     */
    int update(User user);

    /**
     * 根据ID删除记录
     *
     * @param id
     * @return 删除记录的数量
     */
    int deleteById(Long id);
}
