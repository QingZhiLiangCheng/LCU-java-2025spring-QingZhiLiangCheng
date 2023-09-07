package cn.edu.lcu.cs.designpattern.mediator.im.broadcast;

import lombok.Getter;
import lombok.Setter;

/**
 * 即时消息中心的客户
 *
 * @Author Ling
 * @Date 2021/10/22 0:26
 * @Version 1.0
 */
@Getter
@Setter
public class Customer {
    private String name;
    private Long id;
    private RegisterCenter registerCenter;

    public Customer(String name) {
        this.name = name;
    }

    /**
     * 点对点单播消息
     *
     * @param to
     * @param message
     */
    public void send(String to, String message) {
        if (registerCenter != null) {
            registerCenter.dispatchMessage(this.name, to, message);
        } else {
            System.out.println("发送者【" + this.name + "】未注册");
        }
    }

    /**
     * 广播消息
     *
     * @param message
     */
    public void send(String message) {
        registerCenter.broadcast(message);
    }

    public void receive(String from, String message) {
        System.out.println(from + " 发送消息【" + message + "】给 " + this.name);
    }
}
