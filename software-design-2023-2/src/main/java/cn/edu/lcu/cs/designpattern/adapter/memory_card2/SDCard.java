package cn.edu.lcu.cs.designpattern.adapter.memory_card2;

public interface SDCard {
    //读取SD卡方法
    String readSD();
    //写入SD卡功能
    void writeSD(String msg);
}