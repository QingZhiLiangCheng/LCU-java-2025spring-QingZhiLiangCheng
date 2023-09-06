package cn.edu.lcu.cs.design_pattern.mediator.estateagent;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * 客户窗体，与客户交互的界面。
 */
public class CustomerFrame extends JFrame implements ActionListener {
    private EstateAgent agent; // 中介者
    private Customer customer; // 与每个窗口绑定的客户
    private JTextArea historyMessageArea; // 显示历史消息的文本区
    private JTextField messageText; // 接收发送消息的文本域

    public CustomerFrame(Customer customer) throws HeadlessException {
        super(customer.getName()); // 设置窗体的标题
        this.customer = customer;
    }

    public Customer getCustomer() {
        return customer;
    }

    /**
     * 当客户在窗体的文本域输入完信息之后，回车键的事件处理程序。
     *
     * @param e
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        // 取出文本域中用户输入的消息
        String message = messageText.getText().trim();
        send(message); // 发送（广播）消息
        messageText.setText(""); // 文本域清空
    }

    /**
     * 发送消息给中介者，中介者再转发消息给所有人
     *
     * @param message
     */
    private void send(String message) {
        // 请求中介转发消息
        agent.relay(this, message);
    }

    /**
     * 接收消息
     */
    public void receive() {
        // 根据中介者维护的消息历史记录，构造用于显示的文本。
        StringBuilder builder = new StringBuilder();
        agent.getMessages().forEach(message -> builder.append(message.getCustomer().getName()).append("\t").append(message.getMessage()).append("\t").append(message.getPostTime()).append("\n"));
        this.historyMessageArea.setText(builder.toString());
    }

    public void clientWindow(int x, int y) {
        Container container = getContentPane();
        historyMessageArea = new JTextArea(10, 18);
        historyMessageArea.setEditable(false);
        JPanel historyMessagePanel = new JPanel();
        historyMessagePanel.setBorder(BorderFactory.createTitledBorder("历史消息"));
        historyMessagePanel.add(historyMessageArea);
        JScrollPane pane = new JScrollPane(historyMessagePanel);
        container.add(pane, BorderLayout.NORTH);

        JPanel sendMessagePanel = new JPanel();
        sendMessagePanel.setBorder(BorderFactory.createTitledBorder("发送内容"));
        messageText = new JTextField(18);
        sendMessagePanel.add(messageText);
        container.add(sendMessagePanel, BorderLayout.SOUTH);
        messageText.addActionListener(this);

        this.setLocation(x, y);
        this.setSize(400, 330);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public void setAgent(EstateAgent agent) {
        this.agent = agent;
    }
}
