package cn.edu.lcu.cs.architecture.mvc.usermanage.service;


import cn.edu.lcu.cs.architecture.mvc.usermanage.dao.UserDao;
import cn.edu.lcu.cs.architecture.mvc.usermanage.dao.UserDaoImpl;
import cn.edu.lcu.cs.architecture.mvc.usermanage.entity.User;

import java.util.List;

public class UserServiceImpl implements UserService {
    private UserDao userDao = new UserDaoImpl();

    /**
     * 新用户注册
     *
     * @param user
     * @return 注册成功之后的用户对象，包含数据库自动生成的主键
     */
    @Override
    public User register(User user) {
        return userDao.add(user);
    }

    @Override
    public User findById(Long id) {
        return userDao.findById(id);
    }

    /**
     * 根据用户名及密码进行登录确证
     *
     * @param username
     * @param password
     * @return 如果登录成功，返回用户对象；如果登录失败，返回null。
     */
    @Override
    public User login(String username, String password) {
        if (username != null && password != null) {
            User user = userDao.findByUsername(username);
            if (user != null && password.equals(user.getPassword())) {
                return user;
            }
        }
        return null;
    }

    /**
     * @return 库中所有用户
     */
    @Override
    public List<User> findAll() {
        return userDao.findAll();
    }

    /**
     * 根据姓名模糊查询
     *
     * @param username
     * @return
     */
    @Override
    public List<User> findByUsernameLikely(String username) {
        return userDao.findByUsernameLikely(username);
    }

    @Override
    public int delete(Long id) {
        return userDao.deleteById(id);
    }

    @Override
    public int update(User user) {
        return userDao.update(user);
    }
}
