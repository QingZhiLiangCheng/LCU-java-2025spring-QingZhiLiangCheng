package cn.edu.lcu.cs.designpattern.mediator.im.message_center;

/**
 * 消息中心
 *
 * @Author Ling
 * @Date 2021/10/22 0:24
 * @Version 1.0
 */
public class MessageCenter {
    /**
     * 分发消息dispatch，也可以用中继relay。
     *
     * @param from
     * @param to
     * @param message
     */
    public void dispatchMessage(Customer from, Customer to, String message) {
        // 在转发消息之前，可以集中进行一些业务处理
        // 比如加密解密，过滤敏感词，权限验证，等等

        to.receive(from, message);
    }
}
