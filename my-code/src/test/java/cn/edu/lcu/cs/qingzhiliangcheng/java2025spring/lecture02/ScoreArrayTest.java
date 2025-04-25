package cn.edu.lcu.cs.qingzhiliangcheng.java2025spring.lecture02;
import org.junit.jupiter.api.RepeatedTest;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ScoreArrayTest {

    @RepeatedTest(100)
    void generateScore() {
        int score = ScoresArray.generateScore();
        assertTrue(score <= 100);
        assertTrue(score>=0);
    }
}
