package cn.edu.lcu.cs.design_pattern.mediator.im.register_center;

/**
 * 使用注册中心的消息传递客户端
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

        RegisterCenter registerCenter = new RegisterCenter();
        // 登记注册
        registerCenter.register(zhangsan)
                // 如果没有注册登记，注册中心找不到这个对象，它就收不到别人发送的消息
                // .register(wangwu)
                .register(lisi);

        // 仅通过指定名称（或id，qq号码，手机号码等）即可发送消息。
        // 对方存不存在，在不在线，位于何处，发送方都不知道。
        // 消息发送只能通过注册中心转发，但是表面上看不出注册中心的存在，它是透明的。
        zhangsan.send("lisi", "来自宇宙最深处的问候");
        zhangsan.send("wangwu", "来自宇宙最深处的问候");

        lisi.send("wangwu", "外星人给我打招呼了");
        wangwu.send("lisi", "这也信！？智商堪忧啊。");
    }
}
