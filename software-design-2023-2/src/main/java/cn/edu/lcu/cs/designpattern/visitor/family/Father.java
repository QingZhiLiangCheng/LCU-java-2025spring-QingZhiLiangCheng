package cn.edu.lcu.cs.designpattern.visitor.family;

import java.util.List;

/**
 * @Description 家庭成员：父亲
 * @Author Ling
 * @Date 2021/10/6 12:51
 * @Version 1.0
 */
public class Father extends Folk {
    private List<Folk> children;

    @Override
    public void accept(Visitor visitor) {
        // 真实案例可能会有一个判断
        // 如果符合条件才允许访问，
        // 如果不符合条件，要么空操作，要么抛出异常，或者给出一个提示

        // 把自身的引用传递给访问者，允许访问者访问自己
        visitor.visit(this);
    }
}
