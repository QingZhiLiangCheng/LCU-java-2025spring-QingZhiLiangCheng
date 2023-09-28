package cn.edu.lcu.cs.designpattern.flyweight.theory;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * TODO 这里是文档说明，如果未提供，把本行删除。
 *
 * @author ling
 * @date 2022/9/12 14:14
 */
class FlyweightFactoryTest {

    @Test
    void getFlyweight() {
        FlyweightFactory factory = FlyweightFactory.getInstance();
        // 以下两个变量都是根据相同的key获取的，理应是同一个实例。
        Flyweight flyweight1_1 = factory.getFlyweight("享元1");
        Flyweight flyweight1_2 = factory.getFlyweight("享元1");
        assertEquals(flyweight1_1, flyweight1_2);
        assertTrue(flyweight1_1 == flyweight1_2);

        // 下边这个变量是根据不同的key获取的，与上边两个变量是不同的实例。
        Flyweight flyweight2_1 = factory.getFlyweight("享元2");
        assertNotEquals(flyweight1_1, flyweight2_1);
        assertFalse(flyweight1_1 == flyweight2_1);


    }
}