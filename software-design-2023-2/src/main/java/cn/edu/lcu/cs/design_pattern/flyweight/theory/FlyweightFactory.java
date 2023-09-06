package cn.edu.lcu.cs.design_pattern.flyweight.theory;

import java.util.HashMap;
import java.util.Map;

/**
 * 享元工厂类.
 * 创建并管理享元对象。
 *
 * @author ling
 * @date 2022/9/12 11:28
 */
public class FlyweightFactory {
    /**
     * 享元池，通常是映射类型，也可以是其它集合类型。
     */
    private static final Map<String, Flyweight> flyweightPool = new HashMap();

    private static final FlyweightFactory instance = new FlyweightFactory();

    private FlyweightFactory() {
    }

    public static FlyweightFactory getInstance() {
        return instance;
    }

    /**
     * 在享元池中查询享元对象并返回；若不存在，就创建一个，放入池中，并返回。
     *
     * @return
     */
    public Flyweight getFlyweight(String key) {
        if (flyweightPool.containsKey(key)) {
            return flyweightPool.get(key);
        } else {
            Flyweight flyweight = new ConcreteFlyweight(key);
            flyweightPool.put(key, flyweight);
            return flyweight;
        }
    }
}
