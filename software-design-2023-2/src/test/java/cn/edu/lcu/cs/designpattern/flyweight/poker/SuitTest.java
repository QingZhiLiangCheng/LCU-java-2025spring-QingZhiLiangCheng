package cn.edu.lcu.cs.designpattern.flyweight.poker;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

/**
 * @author ling
 * @date 2022/9/11 20:24
 */
class SuitTest {

    @Test
    void values() {
        for (Suit suit : Suit.values()) {
            System.out.println("suit = " + suit);
        }
    }

    /**
     * 对枚举进行参数化测试
     *
     * @param suit
     */
    @ParameterizedTest
    @EnumSource
    // 排除某个枚举值
    //@EnumSource(mode = EnumSource.Mode.EXCLUDE, names = {"HEARTS"})
    void valueOf(Suit suit) {
        System.out.println("suit = " + suit);
    }
}