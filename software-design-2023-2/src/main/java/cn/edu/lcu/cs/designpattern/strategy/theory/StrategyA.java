package cn.edu.lcu.cs.designpattern.strategy.theory;

public class StrategyA implements Strategy {
    /**
     * 具体的算法实现
     */
    @Override
    public void algorithmInterface() {
        System.out.println("算法A");
    }
}
