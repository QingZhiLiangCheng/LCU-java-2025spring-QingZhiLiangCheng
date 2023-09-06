package cn.edu.lcu.cs.design_pattern.command.theory;

import cn.edu.lcu.cs.util.StackTraceUtil;

/**
 * 命令接收者，可能会有很多个接收者。
 */
public class Receiver {

    /**
     * 执行某个动作
     */
    public void action1() {
        System.out.println("接收者执行某些操作");
        StackTraceUtil.printStackTrace();
    }

    /**
     * 执行某个动作
     */
    public void action2() {
        System.out.println("接收者执行某些操作");
        StackTraceUtil.printStackTrace();
    }
}
