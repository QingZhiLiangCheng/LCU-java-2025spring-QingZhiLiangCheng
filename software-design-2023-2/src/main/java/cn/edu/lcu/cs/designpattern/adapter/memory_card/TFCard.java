package cn.edu.lcu.cs.designpattern.adapter.memory_card;

public interface TFCard {
    //读取TF卡方法
    String readTF();
    //写入TF卡功能
    void writeTF(String msg);
}