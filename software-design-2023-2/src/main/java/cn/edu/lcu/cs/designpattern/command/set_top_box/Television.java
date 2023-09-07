package cn.edu.lcu.cs.designpattern.command.set_top_box;

public class Television {
    public void open() {
        System.out.println("电视机打开了");
    }

    public void close() {
        System.out.println("电视机关机了");
    }

    public void changeChannel(String channel) {
        System.out.println("电视机换台到：" + channel);
    }
}
