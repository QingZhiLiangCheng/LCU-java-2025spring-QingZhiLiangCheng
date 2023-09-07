package cn.edu.lcu.cs.designpattern.bridge.remote_control;

public abstract class RemoteControl {
    private TV tv;

    public abstract void on();

    public abstract void off();

    public abstract void setChannel();
}
