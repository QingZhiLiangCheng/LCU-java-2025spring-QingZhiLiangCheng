package cn.edu.lcu.cs.architecture.mvc.usermanage.controller;


import cn.edu.lcu.cs.architecture.mvc.usermanage.entity.User;
import cn.edu.lcu.cs.architecture.mvc.usermanage.model.UserInfoModel;
import cn.edu.lcu.cs.architecture.mvc.usermanage.model.UserSearchModel;
import cn.edu.lcu.cs.architecture.mvc.usermanage.service.UserService;
import cn.edu.lcu.cs.architecture.mvc.usermanage.service.UserServiceImpl;
import cn.edu.lcu.cs.architecture.mvc.usermanage.view.LoginDialog;
import cn.edu.lcu.cs.architecture.mvc.usermanage.view.UserInfoDialog;
import cn.edu.lcu.cs.architecture.mvc.usermanage.view.UserSearchDialog;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

@Getter
@Setter
public class UserController {
    private UserService userService = new UserServiceImpl();
    private UserSearchModel searchModel;
    private UserInfoModel infoModel;

    private LoginDialog loginView;
    private UserSearchDialog searchView;
    private UserInfoDialog infoView;

    /**
     * 根据视图传递过来的参数，决定整个程序的流程。
     *
     * @param action 视图传递过来的动作类型，据此判断程序的流程。
     * @param args   视图传递过来的参数序列，数量与类型可变。
     */
    public void route(RouteAction action, Object... args) {
        switch (action) {
            case LOGIN:
                login((String) args[0], (String) args[1]);
                break;
            case REGISTER:
                register((String) args[0], (String) args[1], (String) args[2]);
                break;
            case EDIT:
                edit((String) args[0], (String) args[1], (String) args[2], (String) args[3]);
                break;
            case SHOW_INFO:
                showInfo((Long) args[0]);
                break;
            case LIST:
                // 查询所有，过滤字符串为空
                search("");
                break;
            case SEARCH:
                // 根据传递过来的过滤字符串作为用户名模糊查询
                search((String) args[0]);
                break;
            case DELETE:
                delete((Long) args[0]);
                break;
        }
    }

    /**
     * 编辑用户信息
     * 视图传递过来的参数都是字符串类型，需要转型。
     * 参数转型，这也是控制器的一个功能点。
     *
     * @param idString
     * @param username
     * @param password
     * @param birthdateString
     */
    private void edit(String idString, String username, String password, String birthdateString) {
        try {
            long id = Long.parseLong(idString);
            LocalDate birthdate = LocalDate.parse(birthdateString);
            // 如果修改成功，searchModel与infoModel的模型数据都变化了，对应的两个视图都会更新显示
            if (searchModel.edit(new User(id, username, password, birthdate))) {
                // 促使对应视图更新显示（显示操作成功的提示）
                infoModel.setMsg("修改成功");
                return;
            }
        } catch (NumberFormatException | DateTimeParseException e) {
            e.printStackTrace();
        }
        // 修改失败了，改变infoModel的模型数据，infoView视图更新显示（显示错误消息提示）
        infoModel.setMsg("修改失败");
    }

    /**
     * 删除用户，模型中的数据会发生变化，导致对应的视图更新显示
     *
     * @param id
     */
    private void delete(Long id) {
        searchModel.delete(id);
    }

    /**
     * 控制器调用模型的方法修改数据，模型数据一旦改变，会通知注册的观察者视图searchView进行显示更新。
     *
     * @param username
     */
    private void search(String username) {
        searchModel.search(username);
    }

    /**
     * 根据id查询用户，并更新infoModel的模型数据，导致对应的视图infoView进行显示更新
     *
     * @param id
     */
    private void showInfo(Long id) {
        infoModel.showInfo(id);
    }

    /**
     * 根据登录结果，返回（显示或关闭）不同的视图，相当于流程控制。
     *
     * @param username
     * @param password
     */
    private void login(String username, String password) {
        User user = userService.login(username, password);
        if (user != null) {
            // 登录成功，释放登录窗口，显示查询窗口与详情窗口
            loginView.dispose();
            searchView.display();
            infoView.display();
        } else {
            // 登录失败，返回登录窗口，继续登录
            loginView.showMsg("用户名密码失败，请重新登录！");
        }
    }

    private void register(String username, String password, String password2) {
        // TODO 待实现
    }

    /**
     * 请求转发（路由）类型
     */
    public enum RouteAction {
        LOGIN, REGISTER, EDIT, SHOW_INFO, LIST, SEARCH, DELETE
    }

}




