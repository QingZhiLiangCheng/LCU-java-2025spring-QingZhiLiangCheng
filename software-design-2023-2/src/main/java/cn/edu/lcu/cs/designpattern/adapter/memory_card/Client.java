package cn.edu.lcu.cs.designpattern.adapter.memory_card;

public class Client {
    public static void main(String[] args) {
        Computer computer = new Computer();

        SDCard sdCard = new SDCardImpl();
        // 读写SD卡
        System.out.println(computer.readSD(sdCard));

        System.out.println("------------");

        SDCard adapter = new TF2SDAdapter();
        // 读写适配器
        System.out.println(computer.readSD(adapter));
    }
}