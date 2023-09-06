package cn.edu.lcu.cs.design_pattern.proxy.theory;

/**
 * 真实主题角色，委托类。
 * 真正执行任务的类，实现了代理接口。
 *
 * @author ling
 * @date 2022/9/16 22:36
 */
public class RealSubject implements Subject {
    @Override
    public void request() {
        System.out.println("真实主题的操作");
    }
}
