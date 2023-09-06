package cn.edu.lcu.cs.design_pattern.state.trafficlight.second;

public class Client {
    public static void main(String[] args) {
        TrafficLightContext context = new TrafficLightContext();
        int length = 10;
        for (int i = 0; i < length; i++) {
            // 打印信号灯颜色
            System.out.println(context.getColor());
            try {
                Thread.sleep(2000); // 休眠2秒钟
                context.change(); // 改变状态
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
