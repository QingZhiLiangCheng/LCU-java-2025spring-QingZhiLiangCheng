package cn.edu.lcu.cs.design_pattern.command.theory.invoke;

/**
 * TODO 这里是文档说明，如果未提供，把本行删除。
 *
 * @author ling
 * @date 2022/10/11 23:37
 */
public class Client {
    public static void main(String[] args) {
        Receiver receiver = new Receiver();

        Invoker invoker = new Invoker(receiver);

        invoker.call();
    }
}
