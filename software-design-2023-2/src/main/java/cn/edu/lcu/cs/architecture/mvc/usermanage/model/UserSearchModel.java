package cn.edu.lcu.cs.architecture.mvc.usermanage.model;


import cn.edu.lcu.cs.architecture.mvc.usermanage.entity.User;
import cn.edu.lcu.cs.architecture.mvc.usermanage.service.UserService;
import cn.edu.lcu.cs.architecture.mvc.usermanage.service.UserServiceImpl;
import cn.edu.lcu.cs.architecture.mvc.usermanage.util.Observable;

import java.util.List;

/**
 * MVC架构，用户查询模型
 */
public class UserSearchModel extends Observable {
    /**
     * 模型数据，查询出的用户列表。
     */
    private List<User> users;

    /**
     * 模型数据，查询关键词。
     * 默认为空串，表示没有查询条件。
     */
    private String searchKey = "";

    /**
     * 依赖底层（业务逻辑层）的功能。
     */
    private UserService userService = new UserServiceImpl();

    public void setSearchKey(String searchKey) {
        this.searchKey = searchKey;
    }

    /**
     * 设置新模型数据，并通知观察者（视图更新界面）。
     *
     * @param users
     */
    public void setUsers(List<User> users) {
        // 更新模型数据
        this.users = users;
        // 将模型数据users推送给观察者
        notifyObservers(users);
    }

    /**
     * 根据用户名模糊查询，重新设置模型数据users。
     *
     * @param username
     */
    public void search(String username) {
        // 保存查询关键字
        setSearchKey(username);
        setUsers(userService.findByUsernameLikely(searchKey));
    }

    /**
     * 删除用户，重新设置模型数据users。
     *
     * @param id
     */
    public void delete(Long id) {
        if (userService.delete(id) == 1) {
            setUsers(userService.findByUsernameLikely(searchKey));
        }
    }

    /**
     * 更新旧记录，重新设置模型数据users。
     *
     * @param user
     * @return
     */
    public boolean edit(User user) {
        if (userService.update(user) == 1) {
            // 根据原来保存的查询关键词，重新查询更新之后的用户列表。
            setUsers(userService.findByUsernameLikely(searchKey));
            return true;
        } else {
            return false;
        }
    }
}
