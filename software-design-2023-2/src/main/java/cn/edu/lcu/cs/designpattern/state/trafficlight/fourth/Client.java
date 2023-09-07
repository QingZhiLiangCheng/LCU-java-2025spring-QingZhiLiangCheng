package cn.edu.lcu.cs.designpattern.state.trafficlight.fourth;

public class Client {
    public static void main(String[] args) throws InterruptedException {
        TrafficLightContext context = new TrafficLightContext();
        int length = 10;
        for (int i = 0; i < length; i++) {
            System.out.println(context.getColor());
            Thread.sleep(2000);
            context.change();
        }
    }
}
