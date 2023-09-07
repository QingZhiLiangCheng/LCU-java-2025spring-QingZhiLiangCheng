package cn.edu.lcu.cs.designpattern.proxy.theory;

/**
 * 代理主题角色，代理类。
 * 包含了对真实主题的引用。
 * 代理主题与真实主题有相同的接口，方便替换真实主题。
 *
 * @author ling
 * @date 2022/9/16 22:34
 */
public class Proxy implements Subject {
    /**
     * 代理的真实主题对象，代理目标。
     */
    private Subject target;

    public Proxy(Subject target) {
        this.target = target;
    }

    @Override
    public void request() {
        // 预处理
        preRequest();
        // 调用真实主题对象
        target.request();
        // 后处理
        postRequest();
    }

    private void preRequest() {
        System.out.println("在调用真实主题操作前进行预处理操作");

    }
    private void postRequest() {
        System.out.println("在调用真实主题操作后进行后处理操作");

    }
}
