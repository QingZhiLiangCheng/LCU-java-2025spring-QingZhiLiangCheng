package cn.edu.lcu.cs.design_pattern.mediator.theory;

public class CollegueC extends Collegue {
    @Override
    public void receive() {
        System.out.println("CollegueC 收到请求");
//        StackTraceUtil.printStackTrace();
    }

    @Override
    public void send() {
        System.out.println("CollegueC 发出请求");
        mediator.relay(this); // 请中介者转发
    }
}
