package cn.edu.lcu.cs.designpattern.visitor.family;

/**
 * @Description 家庭成员：哥哥
 * @Author Ling
 * @Date 2021/10/6 12:53
 * @Version 1.0
 */
public class Brother extends Folk {

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
