package cn.edu.lcu.cs.javaprogramming.gui;

import javax.swing.*;
import java.awt.event.*;

public class LoginDlg extends JDialog {
    private JPanel contentPane;
    private JButton loginBtn;
    private JButton cancelBtn;
    private JTextField usernameField;
    private JPasswordField passwordField;

    public LoginDlg() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(loginBtn);

        loginBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onOK();
            }
        });

        cancelBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        });

        // 点击 X 时调用 onCancel()
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

        // 遇到 ESCAPE 时调用 onCancel()
        contentPane.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
        loginBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                System.out.println("登录按钮被单击了");
//                获取用户输入的名字与密码
                String username = usernameField.getText();
                String password = passwordField.getText();

//                访问数据，判断是否有这个的用户存在
//                System.out.println("username" + username);
//                System.out.println(password);
            }
        });
    }

    private void onOK() {
        // 在此处添加您的代码
        dispose();
    }

    private void onCancel() {
        // 必要时在此处添加您的代码
        dispose();
    }

    public static void main(String[] args) {
        LoginDlg dialog = new LoginDlg();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}
