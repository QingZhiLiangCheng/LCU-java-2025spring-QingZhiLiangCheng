package cn.edu.lcu.cs.design_pattern.visitor.family;

import java.util.ArrayList;
import java.util.List;

/**
 * 容纳所有被访问者的容器对象，用于统一管理。
 * 在访问者模式中，此类非必须。
 */
public class Family {
    private List<Folk> folks = new ArrayList<>();

    public void addFolk(Folk folk) {
        folk.setFamily(this);
        folks.add(folk);
    }

    /**
     * 接受访问者的访问
     *
     * @param visitor
     */
    public void accept(Visitor visitor) {
        // 真实案例可能会有一个判断
        // 如果符合条件才允许访问，
        // 如果不符合条件，要么空操作，要么抛出异常，或者给出一个提示

        // 依次调用每个被访问者的方法
        folks.forEach(folk -> folk.accept(visitor));
    }
}
