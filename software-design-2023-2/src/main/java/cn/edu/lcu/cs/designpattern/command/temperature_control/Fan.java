package cn.edu.lcu.cs.designpattern.command.temperature_control;

import cn.edu.lcu.cs.util.StackTraceUtil;

public class Fan {
    public void startRotate() {
        System.out.println("风扇开始转");
        StackTraceUtil.printStackTrace();
    }

    public void stopRotate() {
        System.out.println("风扇停转了");
    }
}
