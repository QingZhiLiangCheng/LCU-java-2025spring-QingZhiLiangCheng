package cn.edu.lcu.cs.qingzhiliangcheng.java2025spring.lecture13.lambda;

/**
 * 传统的中式打招呼
 *
 * @author ling
 * @date 2022/3/26 23:25
 */
public class TraditionalChineseGreeting implements Greeting {
    @Override
    public String greet(String somebody) {
        return (somebody + ", 吃了吗？");
    }
}
