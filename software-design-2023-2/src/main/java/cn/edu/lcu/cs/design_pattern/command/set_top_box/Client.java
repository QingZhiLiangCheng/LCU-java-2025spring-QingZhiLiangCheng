package cn.edu.lcu.cs.design_pattern.command.set_top_box;


public class Client {
    public static void main(String[] args) {
        RemoteControl remoteControl = new RemoteControl();
        remoteControl.openBox();
        remoteControl.openTv();
        remoteControl.changeBoxChannel("聊大电视台");
        remoteControl.closeTv();
        remoteControl.closeBox();
    }
}
