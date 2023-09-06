package cn.edu.lcu.cs.architecture.mvc.usermanage.view;

import cn.edu.lcu.cs.architecture.mvc.usermanage.controller.UserController;
import cn.edu.lcu.cs.architecture.mvc.usermanage.entity.User;
import cn.edu.lcu.cs.architecture.mvc.usermanage.util.Observable;
import cn.edu.lcu.cs.architecture.mvc.usermanage.util.Observer;

import javax.swing.*;
import java.awt.event.*;

import static cn.edu.lcu.cs.architecture.mvc.usermanage.controller.UserController.RouteAction.EDIT;

public class UserInfoDialog extends JDialog implements Observer {
    public UserController getUserController() {
        return userController;
    }

    public void setUserController(UserController userController) {
        this.userController = userController;
    }

    private UserController userController;
    private JPanel contentPane;
    private JButton editBtn;
    private JButton cancelBtn;
    private JTextField idField;
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JTextField birthdateField;
    private JTextField registerTimeField;
    private JLabel msgField;

    public UserInfoDialog() {
        setContentPane(contentPane);
//        setModal(true);
        getRootPane().setDefaultButton(editBtn);

        editBtn.addActionListener(e -> onEdit());

        cancelBtn.addActionListener(e -> onCancel());

        // call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

        // call onCancel() on ESCAPE
        contentPane.registerKeyboardAction(e -> onCancel(), KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
    }

    public UserInfoDialog(UserController userController) {
        this();
        this.userController = userController;
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }

    /**
     * 用户点击编辑按钮后执行
     */
    private void onEdit() {
        String id = idField.getText();
        String username = usernameField.getText();
        String password = new String(passwordField.getPassword());
        String birthdate = birthdateField.getText();
        // 将用户的输入传递给控制器（均为字符串类型）
        userController.route(EDIT, id, username, password, birthdate);
    }

    /**
     * 当被观察者对象（模型数据）变更时，同步更新显示内容
     *
     * @param observable
     * @param arg        模型推送过来的参数，可能是编辑失败或成功的消息，也可能是用户对象
     */
    @Override
    public void update(Observable observable, Object arg) {
        // 根据模型推送过来的参数类型判断后续操作
        if (arg instanceof User) {
            // 如果推送过来的是用户对象，则是要更新用户信息，并清除消息提示
            User user = (User) arg;
            idField.setText(user.getId() + "");
            usernameField.setText(user.getUsername());
            passwordField.setText(user.getPassword());
            birthdateField.setText(user.getBirthdate().toString());
            registerTimeField.setText(user.getRegisterTime().toString());
            msgField.setText("");
        } else if (arg instanceof String) {
            // 如果传递过来的是字符串，应该是错误消息，更新显示错误消息
            msgField.setText((String) arg);
        }
    }

    public void display() {
        setTitle("用户详情");
        pack();
        setVisible(true);
    }
}
