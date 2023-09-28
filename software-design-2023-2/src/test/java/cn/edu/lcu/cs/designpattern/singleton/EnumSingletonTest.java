package cn.edu.lcu.cs.designpattern.singleton;

import org.junit.jupiter.api.Test;

/**
 * @Description 对用枚举实现的单例模式进行测试。
 * @Author Ling
 * @Date 2021/9/14 23:48
 * @Version 1.0
 */
class EnumSingletonTest {

    @Test
    void doSomething() {
        EnumSingleton.INSTANCE.doSomething();
    }
}