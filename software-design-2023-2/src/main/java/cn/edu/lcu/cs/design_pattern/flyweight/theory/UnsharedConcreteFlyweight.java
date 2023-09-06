package cn.edu.lcu.cs.design_pattern.flyweight.theory;

/**
 * 非共享具体享元类
 *
 * @author ling
 * @date 2022/9/10 0:13
 */
public class UnsharedConcreteFlyweight implements Flyweight {
    private String intrinsicState;

    /**
     * 享元对象的内部状态数据
     */
    private String allState;

    @Override
    public String getIntrinsicState() {
        return intrinsicState;
    }

    public UnsharedConcreteFlyweight(String intrinsicState) {
        this.intrinsicState = intrinsicState;
    }

    @Override
    public void someOperation(String extrinsicState) {

    }
}
