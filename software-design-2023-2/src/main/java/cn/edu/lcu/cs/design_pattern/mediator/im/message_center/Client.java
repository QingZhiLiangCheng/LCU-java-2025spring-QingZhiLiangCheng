package cn.edu.lcu.cs.design_pattern.mediator.im.message_center;

/**
 * 使用消息中心的消息传递客户端
 *
 * @Author Ling
 * @Date 2021/10/22 0:32
 * @Version 1.0
 */
public class Client {
    public static void main(String[] args) {
        MessageCenter messageCenter = new MessageCenter();

        Customer zhangsan = new Customer("zhangsan");
        zhangsan.setMessageCenter(messageCenter);

        Customer lisi = new Customer("lisi");
        lisi.setMessageCenter(messageCenter);

        Customer wangwu = new Customer("wangwu");
        wangwu.setMessageCenter(messageCenter);

        // 两个对象传递消息
        // 表面上看，zhangsan直接发消息给lisi，其实底层是通过消息中心转发的
        zhangsan.send(lisi, "来自宇宙最深处的问候");
        // 收发双方在语法上是直接依赖的，获取对方的引用，解耦不彻底。
        // 既然两个对象的引用都获取了，直接交流不香吗？
        // lisi.receive(zhangsan, "来自宇宙最深处的问候");
        // 应该仅通过对方的一个属性（如名字、ID、QQ号、电话号码等）就可发送消息
        // zhangsan.send("lisi", "来自宇宙最深处的问候");
        // 双方彻底解耦

        zhangsan.send(wangwu, "来自宇宙最深处的问候");

        lisi.send(wangwu, "外星人给我打招呼了");
        wangwu.send(lisi, "这也信！？智商堪忧啊。");
    }
}
