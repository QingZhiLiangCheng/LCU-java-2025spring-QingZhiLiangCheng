package cn.edu.lcu.cs.designpattern.state.thread;

public class Dead extends ThreadState {
    public Dead() {
        stateName = "死亡状态";
        System.out.println(stateName);
    }
}
