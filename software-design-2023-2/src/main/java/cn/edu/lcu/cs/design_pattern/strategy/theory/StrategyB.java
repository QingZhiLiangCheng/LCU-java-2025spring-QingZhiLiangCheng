package cn.edu.lcu.cs.design_pattern.strategy.theory;

public class StrategyB implements Strategy {
    /**
     * 具体的算法实现
     */
    @Override
    public void algorithmInterface() {
        System.out.println("算法B");
    }
}
