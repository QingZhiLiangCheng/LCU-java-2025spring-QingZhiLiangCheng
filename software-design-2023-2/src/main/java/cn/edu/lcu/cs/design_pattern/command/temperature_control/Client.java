package cn.edu.lcu.cs.design_pattern.command.temperature_control;

public class Client {
    public static void main(String[] args) {
        Fan fan = new Fan();
        Invoker invoker = new Invoker(new FanOnCmd(fan));
        invoker.call();
        invoker.setCommand(new FanOffCmd(fan));
        invoker.call();

        RoomWindow window = new RoomWindow();
        invoker.setCommand(new WindowOpenCmd(window));
        invoker.call();
        invoker.setCommand(new WindowCloseCmd(window));
        invoker.call();

    }
}
