package cn.edu.lcu.cs.design_pattern.visitor.family;

/**
 * @Description 爷爷奶奶访问者，爷爷奶奶过节来串门
 * @Author Ling
 * @Date 2021/10/6 13:44
 * @Version 1.0
 */
public class GrandParentVisitor implements Visitor {
    @Override
    public void visit(Mother mother) {
        System.out.println("家里收拾得挺利索啊。");
    }

    @Override
    public void visit(Father father) {
        System.out.println("去把车上东西搬进来。");
    }

    @Override
    public void visit(Brother brother) {
        System.out.println("大孙子哎，这把手枪喜欢吗？");
    }

    @Override
    public void visit(Sister sister) {
        System.out.println("我的小心肝儿，这个娃娃喜欢吗？");
    }
}
