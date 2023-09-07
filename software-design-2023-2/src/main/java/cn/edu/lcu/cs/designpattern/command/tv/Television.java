package cn.edu.lcu.cs.designpattern.command.tv;

public class Television {
    public void open() {
        System.out.println("电视机打开了");
    }

    public void close() {
        System.out.println("电视机关机了");
    }

    public void changeChannel(String channel) {
        System.out.println("换台到：" + channel);
    }
}
