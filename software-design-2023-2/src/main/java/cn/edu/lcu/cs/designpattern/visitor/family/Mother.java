package cn.edu.lcu.cs.designpattern.visitor.family;

import java.util.List;

/**
 * @Description 家庭成员：母亲
 * @Author Ling
 * @Date 2021/10/6 12:51
 * @Version 1.0
 */
public class Mother extends Folk {
    private List<Folk> children;

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);

    }
}
