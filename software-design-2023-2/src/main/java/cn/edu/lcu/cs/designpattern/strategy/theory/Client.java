package cn.edu.lcu.cs.designpattern.strategy.theory;

public class Client {
    public static void main(String[] args) {
        Strategy strategy = new StrategyA();
        Context context = new Context(strategy);
        context.contextInterface();
    }
}
