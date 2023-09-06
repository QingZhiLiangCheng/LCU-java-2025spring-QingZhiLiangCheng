package cn.edu.lcu.cs.design_pattern.bridge.theory;

/**
 * 抽象化角色
 *
 * @author ling
 */
public abstract class Abstraction {
    protected Implementor implementor;

    public Abstraction(Implementor implementor) {
    }

    public abstract void operation();
}
