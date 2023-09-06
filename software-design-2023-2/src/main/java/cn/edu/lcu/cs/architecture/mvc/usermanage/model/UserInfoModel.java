package cn.edu.lcu.cs.architecture.mvc.usermanage.model;

import cn.edu.lcu.cs.architecture.mvc.usermanage.entity.User;
import cn.edu.lcu.cs.architecture.mvc.usermanage.service.UserService;
import cn.edu.lcu.cs.architecture.mvc.usermanage.service.UserServiceImpl;
import cn.edu.lcu.cs.architecture.mvc.usermanage.util.Observable;


public class UserInfoModel extends Observable {
    /**
     * 依赖底层（业务逻辑层）的功能。
     */
    private UserService userService = new UserServiceImpl();

    /**
     * 模型数据，据此更新页面上用户详情信息
     */
    private User user;

    /**
     * 模型数据，页面上显示的消息提示
     */
    private String msg;

    /**
     * 显示用户详情
     *
     * @param id
     */
    public void showInfo(Long id) {
        User user = userService.findById(id);
        if (user == null) {
            this.user = null;
            setMsg("查无此人");
        } else {
            msg = "";
            setUser(user);
        }
    }

    /**
     * 模型数据变了，通知观察者视图进行显示更新。
     *
     * @param user
     */
    public void setUser(User user) {
        this.user = user;
        notifyObservers(user);
    }

    /**
     * 设置编辑成功或失败时的消息。
     * 模型数据变了，通知观察者视图进行显示更新。
     *
     * @param msg
     */
    public void setMsg(String msg) {
        this.msg = msg;
        notifyObservers(msg);
    }
}
