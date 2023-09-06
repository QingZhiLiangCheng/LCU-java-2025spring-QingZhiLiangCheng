package cn.edu.lcu.cs.design_pattern.proxy.theory;

/**
 * @author ling
 * @date 2022/9/16 22:43
 */
public class Client {
    public static void main(String[] args) {
        //真实主题对象
        Subject realSubject = new RealSubject();
        //为真实主题对象创建代理对象
        Subject proxy = new Proxy(realSubject);

        //直接调用真实主题
        realSubject.request();

        //输出分隔线
        System.out.println("-".repeat(40));

        //通过代理调用请求
        proxy.request();

    }
}
