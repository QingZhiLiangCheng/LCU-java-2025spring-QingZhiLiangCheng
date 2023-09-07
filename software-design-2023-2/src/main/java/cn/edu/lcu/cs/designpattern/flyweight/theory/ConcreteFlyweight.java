package cn.edu.lcu.cs.designpattern.flyweight.theory;

/**
 * 具体享元类
 *
 * @author ling
 * @date 2022/9/10 0:13
 */
public class ConcreteFlyweight implements Flyweight {
    /**
     * 享元对象的内部状态数据
     */
    private String intrinsicState;

    public ConcreteFlyweight(String intrinsicState) {
        this.intrinsicState = intrinsicState;
    }

    @Override
    public void someOperation(String extrinsicState) {
        System.out.println(extrinsicState);
    }

    @Override
    public String getIntrinsicState() {
        return intrinsicState;
    }
}
