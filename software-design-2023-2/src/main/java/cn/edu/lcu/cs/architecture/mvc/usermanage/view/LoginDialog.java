package cn.edu.lcu.cs.architecture.mvc.usermanage.view;


import cn.edu.lcu.cs.architecture.mvc.usermanage.controller.UserController;

import javax.swing.*;
import java.awt.event.*;

public class LoginDialog extends JDialog {
    private UserController controller;
    private JPanel contentPane;
    private JButton loginBtn;
    private JButton cancelBtn;
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JLabel loginErrorMsg;

    public LoginDialog() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(loginBtn);

        loginBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onLogin();
            }
        });

        cancelBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        });

        // call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

        // call onCancel() on ESCAPE
        contentPane.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
    }

    public LoginDialog(UserController userController) {
        this();
        setController(userController);
    }

    private void onLogin() {
        String username = usernameField.getText();
        String password = new String(passwordField.getPassword());
        // 把用户的输入交给控制器处理，控制器决定下一步流程
        controller.route(UserController.RouteAction.LOGIN, username, password);
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }

    public void display() {
        setTitle("用户登录");
        pack();
        setDefaultCloseOperation(HIDE_ON_CLOSE);
        setVisible(true);
    }

    public UserController getController() {
        return controller;
    }

    public void setController(UserController controller) {
        this.controller = controller;
    }

    public void showMsg(String msg) {
        loginErrorMsg.setText(msg);
    }
}
