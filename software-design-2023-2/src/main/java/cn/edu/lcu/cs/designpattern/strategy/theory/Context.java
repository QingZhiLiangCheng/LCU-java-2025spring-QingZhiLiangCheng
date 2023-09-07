package cn.edu.lcu.cs.designpattern.strategy.theory;

/**
 * 上下文对象，通常持有一个具体的策略对象
 */
public class Context {
    private Strategy strategy;

    public Context(Strategy strategy) {
        this.strategy = strategy;
    }

    /**
     * 上下文对客户端提供的操作接口，可以有参数和返回值
     */
    public void contextInterface() {
        // 通常会调用具体的策略对象进行算法运算
        strategy.algorithmInterface();
    }
}
