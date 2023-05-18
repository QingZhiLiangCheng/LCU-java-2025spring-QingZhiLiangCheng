package cn.edu.lcu.cs.javaprogramming.dao;


import cn.edu.lcu.cs.javaprogramming.entity.User;

import java.util.List;

/**
 * UserDao
 * <p>
 * 2022/5/22 16:53
 *
 * @Author ling
 */
public interface UserDao {
    /**
     * 查询所有用户
     *
     * @return
     */
    List<User> findAll();

    /**
     * 根据ID查询，返回个体。
     *
     * @param id
     * @return
     */
    User findById(Long id);

    /**
     * 根据用户名查询，返回列表。
     *
     * @param username
     * @return
     */
    List<User> findByUsername(String username);

    /**
     * 根据给定的例子查询，返回列表。<br>
     * 将给定样例中所有非空字段作为查询条件，多个条件采用 and 关系。
     *
     * @param example
     * @return
     */
    List<User> findByExample(User example);

    /**
     * 添加用户。 <br>
     * 若插入成功，数据库自增的主键通过调用参数返回。
     *
     * @param user 待插入数据库的对象，数据库自增的主键ID被该对象带回。
     * @return 添加记录的条数
     */
    int save(User user);

    /**
     * 根据ID删除
     *
     * @param id
     * @return 删除记录的数量
     */
    int deleteById(Long id);

    /**
     * 根据样例中非空字段为条件，删除记录。<br>
     * 各条件采用【与】的关系。
     *
     * @param example
     * @return 删除记录的数量
     */
    int deleteByExample(User example);

    /**
     * 更新记录，依据ID、
     *
     * @param user
     * @return 更新记录的数量
     */
    int update(User user);

    /**
     * 根据用户名及密码进行查询
     *
     * @param username
     * @param password
     * @return
     */
    List<User> findByUsernameAndPassword(String username, String password);
}