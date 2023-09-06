package cn.edu.lcu.cs.design_pattern.command.theory;

public class Client {
    public static void main(String[] args) {
        Invoker invoker = new Invoker();

        invoker.setCommand(new CommandA());
        invoker.call();

        invoker.setCommand(new CommandB());
        invoker.call();
    }
}
