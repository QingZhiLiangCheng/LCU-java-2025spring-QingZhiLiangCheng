package cn.edu.lcu.cs.designpattern.mediator.theory;

public class CollegueB extends Collegue {
    @Override
    public void receive() {
        System.out.println("CollegueB 收到请求");
    }

    @Override
    public void send() {
        System.out.println("CollegueB 发出请求");
        mediator.relay(this); // 请中介者转发
    }
}
