package cn.edu.lcu.cs.design_pattern.mediator.im.interaction;

/**
 * 消息发送接收双方直接两两交互，耦合紧密，关系网复杂。
 *
 * @Author Ling
 * @Date 2021/10/22 0:32
 * @Version 1.0
 */
public class Client {
    public static void main(String[] args) {
        Customer zhangsan = new Customer("zhangsan");
        Customer lisi = new Customer("lisi");
        Customer wangwu = new Customer("wangwu");

        zhangsan.send(lisi, "来自宇宙最深处的问候");
        zhangsan.send(wangwu, "来自宇宙最深处的问候");

        lisi.send(wangwu, "外星人给我打招呼了");
        wangwu.send(lisi, "我也收到外星人的消息了");
        // 消息发送接收双方直接两两交互，耦合紧密，关系网复杂。
    }
}
