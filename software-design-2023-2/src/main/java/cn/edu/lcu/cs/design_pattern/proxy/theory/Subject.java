package cn.edu.lcu.cs.design_pattern.proxy.theory;

/**
 * 抽象主题角色，代理接口。
 * 声明真实主题与代理主题的共同接口。
 * 在任何使用真实主题的地方都可以使用代理主题。
 *
 * @author ling
 * @date 2022/9/16 22:30
 */
public interface Subject {
    /**
     * 执行某些任务
     */
    public void request();
}
