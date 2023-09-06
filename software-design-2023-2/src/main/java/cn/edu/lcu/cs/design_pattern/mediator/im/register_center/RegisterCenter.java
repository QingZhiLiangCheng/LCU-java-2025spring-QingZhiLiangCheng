package cn.edu.lcu.cs.design_pattern.mediator.im.register_center;

import java.util.HashMap;
import java.util.Map;

/**
 * 消息中心
 *
 * @Author Ling
 * @Date 2021/10/22 0:24
 * @Version 1.0
 */
public class RegisterCenter {
    private Map<String, Customer> customers = new HashMap<>();

    public RegisterCenter register(Customer customer) {
        if (customer != null) {
            customer.setRegisterCenter(this);
            customers.put(customer.getName(), customer);
        }
        return this;
    }

    /**
     * 分发消息dispatch，也可以用中继relay。
     *
     * @param from    发送方名称
     * @param to      接收方名称
     * @param message 消息文本
     */
    public void dispatchMessage(String from, String to, String message) {
        // 在转发消息之前，可以集中进行一些业务处理
        // 比如加密解密，过滤敏感词，权限验证，等等

        Customer fromCustomer = customers.get(from);
        Customer toCustomer = customers.get(to);
        if (fromCustomer == null) {
            System.out.println("发送者【" + from + "】为空");
        } else if (toCustomer == null) {
            System.out.println("接收者【" + to + "】为空");
        } else {
            toCustomer.receive(from, message);
        }
    }
}
