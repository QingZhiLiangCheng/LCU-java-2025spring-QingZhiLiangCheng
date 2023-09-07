package cn.edu.lcu.cs.designpattern.adapter.object;

/**
 * 目标接口，客户的新需求。
 * 其中某些操作是既有类或第三方类已经具有的，这个轮子就不能重复造了。
 */
public interface Target {
    void operation1();

    void operation2();

    void operation3();
}
