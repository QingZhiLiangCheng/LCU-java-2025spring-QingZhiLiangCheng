package cn.edu.lcu.cs.javaprogramming.basic.array;

import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class ScoresArrayTest {

    //    @Test
    @RepeatedTest(10000)
    void generateScore() {
        int score = ScoresArray.generateScore();
//        System.out.println(score);
        assertTrue(score >= 0);
        assertTrue(score <= 100);
    }

    @Test
    void generateScores() {
        int[] scores = ScoresArray.generateScores(41);
        // Arrays工具类转化数组为字符串
//        System.out.println(Arrays.toString(scores));
        for (int score : scores) {
//            System.out.print(score + ", ");
            assertTrue(score <= 100 && score >= 0);
        }
    }
}