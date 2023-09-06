package cn.edu.lcu.cs.design_pattern.mediator.im.interaction;

import lombok.Getter;
import lombok.Setter;

/**
 * 客户，可与其他客户直接通信
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

    public Customer(String name) {
        this.name = name;
    }

    public void send(Customer to, String message) {
        to.receive(this, message);
    }

    public void receive(Customer from, String message) {
        System.out.println(from.getName() + " 发送消息【" + message + "】给 " + this.name);
    }

}
