package cn.edu.lcu.cs.architecture.mvc.usermanage.view;

import cn.edu.lcu.cs.architecture.mvc.usermanage.controller.UserController;
import cn.edu.lcu.cs.architecture.mvc.usermanage.entity.User;
import cn.edu.lcu.cs.architecture.mvc.usermanage.util.Observable;
import cn.edu.lcu.cs.architecture.mvc.usermanage.util.Observer;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.event.*;
import java.util.List;

import static cn.edu.lcu.cs.architecture.mvc.usermanage.controller.UserController.RouteAction.*;

public class UserSearchDialog extends JDialog implements Observer {
    private List<User> users;
    private UserController controller;
    private JPanel contentPane;
    private JButton searchBtn;
    private JButton exitBtn;
    private JTable usersTable;
    private JTextField usernameField;
    private JButton deleteBtn;

    public UserSearchDialog() {
        setContentPane(contentPane);
//        setModal(true);
        getRootPane().setDefaultButton(searchBtn);

        searchBtn.addActionListener(e -> onSearch());

        exitBtn.addActionListener(e -> onCancel());

        // call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

        // call onCancel() on ESCAPE
        contentPane.registerKeyboardAction(e -> onCancel(), KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);

        usernameField.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                usernameField.selectAll(); // 获取焦点后全选所有文本
            }
        });
        deleteBtn.addActionListener(e -> onDelete());

        // 为表格添加行选中事件监听器
        usersTable.getSelectionModel().addListSelectionListener(e -> onInfo(e));

    }

    public UserSearchDialog(UserController userController) {
        this();
        this.controller = userController;
    }

    private void onInfo(ListSelectionEvent e) {
        System.out.println(e);
        int selectedRow = usersTable.getSelectedRow();
        if (selectedRow != -1) {
            // 获取选中行的ID列
            Object id = usersTable.getValueAt(selectedRow, 0);
            // 调用核心路由，把选中行的用户ID传递过去。
            // 至于控制器如何处理模型数据，结果会展现在哪个视图，此处完全不考虑。
            controller.route(SHOW_INFO, id);
        }
    }

    private void onDelete() {
        int selectedRow = usersTable.getSelectedRow();
        if (selectedRow != -1) {
            Long id = (Long) usersTable.getValueAt(usersTable.getSelectedRow(), 0);
            controller.route(DELETE, id); // 根据ID删除
        }
    }

    /**
     * 根据输入的用户名进行模糊查询，将结果显示在表格中。
     */
    private void onSearch() {
        // 获取用户的输入
        String searchKey = usernameField.getText();
        // 把用户的输入交给控制器处理，控制器决定下一步流程
        controller.route(SEARCH, searchKey);
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }

    /**
     * 观察者的更新操作
     *
     * @param o
     * @param arg
     */
    @Override
    public void update(Observable o, Object arg) {
        users = (List<User>) arg;
        updateTableView();
    }

    /**
     * 更新表格视图
     */
    private void updateTableView() {
        // 将用户列表中的数据显示到表格中
        if (users != null/* && users.size() > 0*/) {
            // 表格头部的定义，即定义各列的名称
            String[] headers = {"ID", "用户名", "密码", "生日"};
            // 表格行列数据（二维数组），行数为用户列表中元素的数量
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
            // Swing组件本身基于MVC设计，当组件的Model改变了，对应的View就会同步更新
            // TableModel接口与JTable对应，DefaultTableModel是其默认实现类
            // 创建TableModel时指定数据行列矩阵（二维数组）与标题行
            TableModel tableModel = new DefaultTableModel(rows, headers);
            // 为JTable对象设置model数据，界面上即可显示出数据
            usersTable.setModel(tableModel);
        }
    }

    /**
     * 显示窗口
     */
    public void display() {
        setTitle("用户查询");
        pack();
        setVisible(true);
        // 窗口初次显示的时候，在查询按钮上手动触发一次动作事件，间接导致SearchView显示更新
        searchBtn.doClick();
        // 手动触发选中（0，0）单元格，间接导致详情视图显示更新
        usersTable.getSelectionModel().setSelectionInterval(0, 0);
    }

    public UserController getController() {
        return controller;
    }

    public void setController(UserController controller) {
        this.controller = controller;
    }
}
