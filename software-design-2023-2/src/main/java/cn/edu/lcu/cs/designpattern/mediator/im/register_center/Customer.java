package cn.edu.lcu.cs.designpattern.mediator.im.register_center;

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
     * 发送消息。
     * 因为消息是通过注册中心转发的，
     * 对方存不存在，在不在线，位于何处，发送方都不知道，更无法获得对方的引用，
     * 所以只能通过名称（或id，qq号码，手机号码等）指定接收方，
     * 注册中心会根据这些属性去查找接收方的引用。
     *
     * @param to      接收者的名字
     * @param message 发送的消息文本
     */
    public void send(String to, String message) {
        if (registerCenter != null) {
            // 让注册中心帮忙转发消息
            registerCenter.dispatchMessage(this.name, to, message);
        } else {
            System.out.println("发送者【" + this.name + "】未注册");
        }
    }

    /**
     * 接收消息。
     *
     * @param from 发送方的名字
     * @param message 接收到的消息文本
     */
    public void receive(String from, String message) {
        System.out.println(from + " 发送消息【" + message + "】给 " + this.name);
    }

}
