package cn.edu.lcu.cs.designpattern.mediator.im.broadcast;

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
                .register(lisi)
                .register(wangwu);

        // 点对点单播
        // zhangsan.send("lisi", "来自宇宙最深处的问候");
        // 没有指定接收者，那就是谁都可以收听，就是广播喽
        zhangsan.send("来自宇宙最深处的问候");

        lisi.send("wangwu", "外星人给我打招呼了");
        wangwu.send("lisi", "这也信！？智商堪忧啊。");
    }
}
