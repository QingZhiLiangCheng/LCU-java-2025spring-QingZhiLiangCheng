package cn.edu.lcu.cs.javaprogramming.annotations;


import cn.edu.lcu.cs.javaprogramming.collection.Score;
import cn.edu.lcu.cs.javaprogramming.collection.ScoreUtil;
import cn.edu.lcu.cs.javaprogramming.oop.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Range注解的测试代码
 *
 * @author ling
 * @date 2022/5/7 22:25
 */
class RangeValidatorTest {
    @Test
    void validateScore() throws IllegalAccessException {
        // 获取一个成绩对象。
        Score score = ScoreUtil.nextScore();
        System.out.println("score = " + score);
        // 因为生成算法中已经保证了成绩都是0~100的，所以成绩都是有效的。
        assertTrue(RangeValidator.validate(score));

        // 把平时成绩设置为-1，这是一个无效的成绩
        score.setOrdinaryScore(-1);
        System.out.println("score = " + score);
        // 如果用rangeValidator进行验证，应该通不过，返回false
        assertFalse(RangeValidator.validate(score));
    }

    @Test
    void validateUser() throws IllegalAccessException {
        // 对用户的工资进行验证
//        @Range(min = 1550, max = Integer.MAX_VALUE)

        User user = new User();
        user.setId(0L);
        System.out.println("user = " + user);
//        System.out.println("RangeValidator.validate(user) = " + RangeValidator.validate(user));
        assertFalse(RangeValidator.validate(user));

        user.setId(1L);
        user.setSalary(2000.);
        System.out.println("user = " + user);
        assertTrue(RangeValidator.validate(user));
    }
}