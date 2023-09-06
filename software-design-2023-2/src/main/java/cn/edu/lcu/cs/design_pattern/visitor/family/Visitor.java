package cn.edu.lcu.cs.design_pattern.visitor.family;

/**
 * 访问者接口，它的每个实现类代表了不同的访问算法，它把比较稳定的数据结构与算法剥离开。
 * 每个家庭成员的访问方式不同，所以有一系列重载的访问方法。
 *
 * @Author Ling
 * @Date 2021/10/6 12:57
 * @Version 1.0
 */
public interface Visitor {
    /**
     * 访问母亲
     *
     * @param mother
     */
    void visit(Mother mother);

    /**
     * 访问父亲
     *
     * @param father
     */
    void visit(Father father);

    /**
     * 访问哥哥
     *
     * @param brother
     */
    void visit(Brother brother);

    /**
     * 访问妹妹
     *
     * @param sister
     */
    void visit(Sister sister);
}
