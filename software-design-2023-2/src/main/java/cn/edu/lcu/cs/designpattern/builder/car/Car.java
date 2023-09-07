package cn.edu.lcu.cs.designpattern.builder.car;

import java.util.ArrayList;
import java.util.List;

public abstract class Car {
    public void setSequence(List<String> sequence) {
        this.sequence = sequence;
    }

    // 方法执行的顺序
    private List<String> sequence = new ArrayList<>();

    protected abstract void start();
    protected abstract void stop();
    protected abstract void alarm();

    public void run() {
        for (String action : sequence) {
            switch (action) {
                case "start":
                    this.start();
                    break;
                case "stop":
                    this.stop();
                    break;
                case "alarm":
                    this.alarm();
                    break;
            }
        }
    }


}
