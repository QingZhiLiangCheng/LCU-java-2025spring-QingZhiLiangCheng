package cn.edu.lcu.cs.designpattern.command.theory.invoke;

/**
 * 命令接收者，可能会有很多个接收者。
 */
public class Receiver {

    /**
     * 执行某个动作
     */
    public void action() {
        System.out.println("接收者执行的某些操作");
    }

}
