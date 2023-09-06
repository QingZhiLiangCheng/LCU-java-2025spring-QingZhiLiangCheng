package cn.edu.lcu.cs.architecture.layerdemo.ui;

import cn.edu.lcu.cs.architecture.layerdemo.entity.User;
import cn.edu.lcu.cs.architecture.layerdemo.service.UserService;
import cn.edu.lcu.cs.architecture.layerdemo.service.UserServiceImpl;

import javax.swing.*;
import javax.swing.table.*;
import java.awt.event.*;
import java.util.List;

public class UserListDialog extends JDialog {
    private UserService userService = new UserServiceImpl();
    private JPanel contentPane;
    private JButton searchBtn;
    private JButton exitBtn;
    private JTable usersTable;
    private JTextField usernameField;

    public UserListDialog() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(searchBtn);

        searchBtn.addActionListener(e -> onSearch());

        exitBtn.addActionListener(e -> onCancel());

        // call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

        // call onCancel() on ESCAPE
        contentPane.registerKeyboardAction(e -> onCancel(), KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);

        // 用代码（而不是用户点击）触发一次action事件，隐式调用onSearch方法，查询所有用户列表
        searchBtn.doClick();
        usernameField.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                usernameField.selectAll(); // 获取焦点后全选所有文本
            }
        });
    }

    /**
     * 根据输入的用户名进行模糊查询，将结果显示在表格中。
     */
    private void onSearch() {
        // 获取用户的输入
        String username = usernameField.getText();
        // 根据用户名模糊查询用户列表
        List<User> users = userService.findByUsernameLikely(username);
        // 将用户列表中的数据显示到表格中
        if (users != null/* && users.size() > 0*/) {
            // 表格头部的定义，即定义各列的名称
            String[] headers = {"ID", "姓名", "密码", "生日"};
            // 表格各行数据，行数为用户列表中元素的数量
            Object[][] rows = new Object[users.size()][];
            for (int i = 0; i < rows.length; i++) {
                // 创建一个对象数组，存储单个用户的各列信息，长度为头部数组的长度
                Object[] row = new Object[headers.length];
                // 从用户列表中获取当前用户
                User user = users.get(i);
                // 将当前用户的属性转存到对象数组中
                row[0] = user.getId();
                row[1] = user.getUsername();
                row[2] = user.getPassword();
                row[3] = user.getBirthdate();
                rows[i] = row; // 将当前用户各列对应的一行数据添加到所有行对应的数组中
            }
            // 为JTable对象设置model数据，界面上即可显示出数据
            usersTable.setModel(new DefaultTableModel(rows, headers));
        }
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }

    public static void main(String[] args) {
        UserListDialog dialog = new UserListDialog();
        dialog.setTitle("用户查询");
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}
