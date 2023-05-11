package cn.edu.lcu.cs.javaprogramming.reflect;

import cn.edu.lcu.cs.javaprogramming.collection.Score;
import cn.edu.lcu.cs.javaprogramming.collection.ScoreUtil;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BeanUtilTest {

    @Test
    void printFields() throws IllegalAccessException {
        Score score = ScoreUtil.nextScore();
        BeanUtil.printFields(score);
    }
}