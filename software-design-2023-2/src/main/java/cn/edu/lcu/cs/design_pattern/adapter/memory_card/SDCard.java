package cn.edu.lcu.cs.design_pattern.adapter.memory_card;

public interface SDCard {
    //读取SD卡方法
    String readSD();
    //写入SD卡功能
    void writeSD(String msg);
}