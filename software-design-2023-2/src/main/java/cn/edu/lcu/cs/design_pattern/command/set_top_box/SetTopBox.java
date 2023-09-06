package cn.edu.lcu.cs.design_pattern.command.set_top_box;

/**
 * 机顶盒
 */
public class SetTopBox {
    public void open() {
        System.out.println("机顶盒打开了");
    }

    public void close() {
        System.out.println("机顶盒关机了");
    }

    public void changeChannel(String channel) {
        System.out.println("机顶盒换台到：" + channel);
    }
}
