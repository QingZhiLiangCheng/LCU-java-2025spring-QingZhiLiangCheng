package cn.edu.lcu.cs.javaprogramming.basic.array;

import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ScoresArrayTest {

    @Test
    void generateScores() {
    }

    @Test
    void print() {
    }

    //@Test
    @RepeatedTest(1000)
    void generateScore() {
        //System.out.println(ScoresArray.generateScore());
        int score = ScoresArray.generateScore();
        assertTrue(score >= 0 && score <= 100);
    }
}