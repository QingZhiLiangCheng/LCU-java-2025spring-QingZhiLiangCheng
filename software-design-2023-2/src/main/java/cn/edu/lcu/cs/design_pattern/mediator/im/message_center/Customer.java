package cn.edu.lcu.cs.design_pattern.mediator.im.message_center;

import lombok.Getter;
import lombok.Setter;

/**
 * 即时消息中心的客户
 * @Author Ling
 * @Date 2021/10/22 0:26
 * @Version 1.0
 */
@Getter
@Setter
public class Customer {
    private String name;
    private Long id;
    private MessageCenter messageCenter;

    public Customer(String name) {
        this.name = name;
    }

    public void send(Customer to, String message) {
        messageCenter.dispatchMessage(this, to, message);
    }

    public void receive(Customer from, String message) {
        System.out.println(from.getName() + " 发送消息【" + message + "】给 " + this.name);
    }

}
