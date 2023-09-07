package cn.edu.lcu.cs.designpattern.bridge.theory;

/**
 * 修正抽象化角色，扩展抽象化角色，改变和修正父类对抽象化的定义。
 *
 * @author ling
 */
public class RefinedAbstraction extends Abstraction {
    public RefinedAbstraction(Implementor implementor) {
        super(implementor);
    }

    @Override
    public void operation() {
        implementor.operationImpl();
    }
}
