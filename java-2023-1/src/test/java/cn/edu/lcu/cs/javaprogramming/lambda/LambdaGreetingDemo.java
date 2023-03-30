package cn.edu.lcu.cs.javaprogramming.lambda;

import lombok.extern.java.Log;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

/**
 * Lambda语法： <code> ([数据类型 参数名, 数据类型 参数名, ...]) -> {表达式主体} </code>
 *
 * @author ling
 * @date 2022/3/23 16:05
 */
@Log
public class LambdaGreetingDemo {

    private Greeting greeting;

    /**
     * 用匿名内部类的方式实现Greeting接口，完成打招呼。
     */
    @Test
    void greetingWithAnonymousInnerClass() {
        // 代码填空


        log.info(greeting.greet("zhangsan"));
    }

    /**
     * 用Lambda表达式的方式实现Greeting接口，完成打招呼。
     */
    @Test
    void greetingWithLambda() {
        // 代码填空


        log.info(greeting.greet("zhangsan"));
    }

    /**
     * 静态方法引用
     */
    @Test
    void greetingWithMethodReferenceHello() {
        // 引用静态方法 cn.edu.lcu.cs.javaprogramming.lambda.Hello.sayHello
        // 代码填空


        log.info(greeting.greet("lisi"));
    }

    /**
     * 实例方法引用
     */
    @Test
    void greetingWithMethodReferenceTraditionalChineseGreeting() {
        // 引用实例方法 cn.edu.lcu.cs.javaprogramming.lambda.TraditionalChineseGreeting.greet
        // 代码填空


        log.info(greeting.greet("zhangsan"));
    }


    /**
     * 静态方法引用
     */
    @Test
    void greetingWithMethodReferenceClassNameStaticMethod() {
        // 引用静态方法 cn.edu.lcu.cs.javaprogramming.lambda.Anything.any
        // 此方法签名与 cn.edu.lcu.cs.javaprogramming.lambda.Greeting.greet 相比，仅方法名称不同
        // 代码填空

        log.info(greeting.greet("lisi"));
    }

    /**
     * 演示方法引用：类名::实例方法名
     * 本例完全没有任何实际意义，仅仅为了演示而演示。
     */
    @Test
    void greetingWithMethodReferenceClassNameInstanceMethod() {
        // 引用String类中 public String toUpperCase()
        // 类名::实例方法名，引用实例方法
        // 所谓【实例】，是哪个呢？
        // 函数式接口中唯一抽象方法的签名：String greet(String somebody);
        greeting = String::toUpperCase;

        // 等价的Lambda表达式
        //greeting = s -> s.toUpperCase();

        // 等价的匿名内部类
        //greeting = new Greeting() {
        //    @Override
        //    public String greet(String s) {
        //        return s.toUpperCase();
        //    }
        //};

        // 总结：Lambda参数列表中的第一个参数是实例方法的参数调用者【即实例】，而第二个参数是实例方法的参数。

        log.info(greeting.greet("lisi"));
    }

    @AfterEach
    void afterEach() {
        System.out.println("------------------------------------------------");
    }
}
