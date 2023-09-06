package cn.edu.lcu.cs.design_pattern.adapter.memory_card;

public class SDCardImpl implements SDCard {
    @Override
    public String readSD() {
        String msg = "sd card read a msg :hello word SD";
        return msg;
    }

    @Override
    public void writeSD(String msg) {
        System.out.println("sd card write msg : " + msg);
    }
}