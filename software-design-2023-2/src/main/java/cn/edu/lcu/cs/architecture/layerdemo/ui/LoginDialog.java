package cn.edu.lcu.cs.architecture.layerdemo.ui;

import cn.edu.lcu.cs.architecture.layerdemo.entity.User;
import cn.edu.lcu.cs.architecture.layerdemo.service.UserService;
import cn.edu.lcu.cs.architecture.layerdemo.service.UserServiceImpl;

import javax.swing.*;
import java.awt.event.*;

public class LoginDialog extends JDialog {
    private UserService userService = new UserServiceImpl();
    private JPanel contentPane;
    private JButton loginBtn;
    private JButton cancelBtn;
    private JTextField usernameField;
    private JPasswordField passwordField;

    public LoginDialog() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(loginBtn);

        loginBtn.addActionListener(e -> onLogin());

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

    private void onLogin() {
        String username = usernameField.getText();
        String password = new String(passwordField.getPassword());
        User user = userService.login(username, password);
        if (user != null) {
            JOptionPane.showMessageDialog(null, "欢迎你，" + username);
            showListDialog(); // 显示用户列表窗口
        } else {
            JOptionPane.showMessageDialog(null, "登录失败");
        }
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }

    private void showListDialog() {
        UserListDialog dialog = new UserListDialog();
        dialog.setTitle("用户查询");
        dialog.pack();
        dialog.setVisible(true);
    }

    public static void main(String[] args) {
        LoginDialog dialog = new LoginDialog();
        dialog.setTitle("用户登录");
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}
