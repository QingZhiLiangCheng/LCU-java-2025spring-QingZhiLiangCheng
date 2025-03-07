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
        // TODO Arrays打印
//        System.out.println(scores);
    }
}