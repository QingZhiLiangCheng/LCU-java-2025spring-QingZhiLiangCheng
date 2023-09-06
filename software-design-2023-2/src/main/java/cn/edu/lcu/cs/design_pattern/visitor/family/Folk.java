package cn.edu.lcu.cs.design_pattern.visitor.family;

/**
 * @Description 家庭成员，家人
 * @Author Ling
 * @Date 2021/10/6 12:50
 * @Version 1.0
 */
public abstract class Folk {
    private Family family;
    private String name;
    private int age;

    /**
     * 接受访问者的访问。
     * 可能会有一个判断：
     * 如果符合条件才允许访问，
     * 如果不符合条件，要么空操作，要么抛出异常，或者给出一个提示。
     *
     * @param visitor
     */
    public abstract void accept(Visitor visitor);

    public void setFamily(Family family) {
        this.family = family;
    }

}
