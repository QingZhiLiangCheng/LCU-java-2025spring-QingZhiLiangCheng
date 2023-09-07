package cn.edu.lcu.cs.designpattern.state.trafficlight.first;

public class Client {
    public static void main(String[] args) throws InterruptedException {
        TrafficLightContext context = new TrafficLightContext();
        int length = 10;
        for (int i = 0; i < length; i++) {
            // 打印信号灯颜色
            System.out.println(context.getColor());
            Thread.sleep(2000); // 休眠2秒钟
            context.change(); // 改变状态
        }
    }
}
