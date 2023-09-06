package cn.edu.lcu.cs.design_pattern.mediator.theory;

public class CollegueA extends Collegue {
    @Override
    public void receive() {
        System.out.println("CollegueA 收到请求");
    }

    @Override
    public void send() {
        System.out.println("CollegueA 发出请求");
        mediator.relay(this); // 请中介者转发
    }
}
