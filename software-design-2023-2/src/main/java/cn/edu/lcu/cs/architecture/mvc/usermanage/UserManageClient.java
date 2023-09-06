package cn.edu.lcu.cs.architecture.mvc.usermanage;

import cn.edu.lcu.cs.architecture.mvc.usermanage.controller.UserController;
import cn.edu.lcu.cs.architecture.mvc.usermanage.model.UserInfoModel;
import cn.edu.lcu.cs.architecture.mvc.usermanage.model.UserSearchModel;
import cn.edu.lcu.cs.architecture.mvc.usermanage.view.LoginDialog;
import cn.edu.lcu.cs.architecture.mvc.usermanage.view.UserInfoDialog;
import cn.edu.lcu.cs.architecture.mvc.usermanage.view.UserSearchDialog;

public class UserManageClient {
    public static void main(String[] args) {
        // 创建控制器对象
        UserController userController = new UserController();

        // 创建视图对象
        LoginDialog loginView = new LoginDialog(userController);
        UserSearchDialog searchView = new UserSearchDialog(userController);
        UserInfoDialog infoView = new UserInfoDialog(userController);

        userController.setLoginView(loginView);
        userController.setSearchView(searchView);
        userController.setInfoView(infoView);

        // 创建模型对象
        UserInfoModel userInfoModel = new UserInfoModel();
        UserSearchModel userSearchModel = new UserSearchModel();

        // 为模型对象注册视图对象，每个模型可以注册多个观察者
        userSearchModel.register(searchView);
        userInfoModel.register(infoView);

        // 将模型对象设置给控制器对象
        userController.setInfoModel(userInfoModel);
        userController.setSearchModel(userSearchModel);

        // 启动登录窗口，开始系统工作流程
        loginView.display();
    }
}
