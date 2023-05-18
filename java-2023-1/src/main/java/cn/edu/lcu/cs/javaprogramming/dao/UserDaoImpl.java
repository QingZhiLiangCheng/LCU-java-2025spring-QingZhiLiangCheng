package cn.edu.lcu.cs.javaprogramming.dao;

import cn.edu.lcu.cs.javaprogramming.entity.User;

import java.util.List;

public class UserDaoImpl implements UserDao {
    @Override
    public List<User> findAll() {
        return null;
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
        return 0;
    }

    @Override
    public int deleteById(Long id) {
        return 0;
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
        return null;
    }
}
