package cn.edu.lcu.cs.javaprogramming.collection;

import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * 通过成绩单演示List操作。
 *
 * @author ling
 * @date 2022/4/11 17:10
 */
// 指定测试方法执行的顺序
// 通过Order注解设置执行顺序
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ScoreListDemo {
    private static final int STUDENT_AMOUNT = 5;
    /**
     * 成绩列表，接口类型。不要声明为任何实现类。
     */
    static List<Score> scores;

    /**
     * 在所有测试方法执行前运行本方法，仅运行一次，静态初始化。
     */
    @BeforeAll
    static void beforeAll() {
        // 创建一个具体类的实例，给接口类型的变量赋值。
        // 到底是接口类型的哪个实现类，需要根据具体情况灵活选择。
        // 如果增删操作不频繁，基本都是查询操作，用此种实现类。
        scores = new ArrayList<>();

        //scores = new LinkedList<>();

        for (int i = 0; i < STUDENT_AMOUNT; i++) {
            Score score = nextScore();
            score.setId((long) (i + 1));
            // 追加对象到列表尾部
            // 列表的容量会根据容纳元素的多少自动调整
            scores.add(score);
        }
    }

    /**
     * 随机生成下一个成绩对象。
     *
     * @return
     */
    private static Score nextScore() {
        Random random = new Random();
        // 将随机生成的10000以内的整数格式化为4字符宽度的字符串
        String randomString = String.format("%04d", random.nextInt(10000));

        Score score = Score.builder()
                .clazzName(random.nextBoolean() ? "5班" : "6班")
                .studentName("学生" + randomString)
                .studentNo("202320" + randomString)
                .build();
        return score;
    }

    /**
     * 根据平时成绩排序
     */
    @Test
    @Order(4)
    void sortScores() {
        // 根据平时成绩排序
        // 代码填空
        scores.sort((s1, s2) -> s1.getOrdinaryScore().compareTo(s2.getOrdinaryScore()));

        System.out.println("sortScores");
        print(scores);
    }

    /**
     * 删除不及格的成绩
     */
    @Test
    @Order(3)
    void deleteFailingScores() {
        // 删除不及格的平时成绩
        // 代码填空
        // 用foreach遍历的时候，不能修改列表的结构，否则出并发错误
//        for (Score score : scores) {
//            if (score.getOrdinaryScore()<60) {
//                scores.remove(score);
//            }
//        }

//        for (int i = 0; i < scores.size(); i++) {
//            Score score = scores.get(i);
//            if (score.getOrdinaryScore()<60) {
//                scores.remove(score);
//            }
//        }

        for (int i = scores.size() - 1; i >= 0; i--) {
            Score score = scores.get(i);
            if (score.getOrdinaryScore()<60) {
                scores.remove(score);
            }
        }

        System.out.println("deleteFailingScores");
        print(scores);
    }

    /**
     * 获取不及格的成绩，并打印
     */
    @Test
    @Order(2)
    void getFailingScores() {
        List<Score> failingScores = new ArrayList<>();

        // 获取平时成绩不及格的成绩
        // 代码填空 scores.for
        for (Score score : scores) {
//            score.getOrdinaryScore()<60.if
            if (score.getOrdinaryScore()<60) {
                failingScores.add(score);
            }
        }

        System.out.println("getFailingScores");
        print(failingScores);
    }

    /**
     * 随机生成成绩，并给成绩列表中的各项的平时成绩赋值。
     */
    @Test
    // 指定测试执行的顺序。
    // 先设置成绩，后续才能对成绩进行处理。
    @Order(1)
    void setOrdinaryScores() {
        // 随机生成若干个成绩
        int[] randomScores = new Random().ints(STUDENT_AMOUNT, 0, 101).toArray();
        // 循环将随机成绩赋值给成绩列表中的平时成绩
        // 代码填空
        for (int i = randomScores.length - 1; i >= 0; i--) {
            scores.get(i).setOrdinaryScore(randomScores[i]);
        }

        //遍历打印
        System.out.println("setOrdinaryScores");
        print(scores);
    }

    /**
     * 遍历打印指定的成绩单
     *
     * @param scores
     */

    void print(List<Score> scores) {
        // 遍历打印成绩
        // 代码填空
//        scores.fori
//        for (int i = 0; i < scores.size(); i++) {
//            System.out.println(scores.get(i));
//        }

//        scores.forr
//        for (int i = scores.size() - 1; i >= 0; i--) {
//
//        }

//        scores.for
        for (Score score : scores) {
            System.out.println(score);
        }

        // Index 5 out of bounds for length 5
        // scores.get(5);


    }

    @AfterEach
    void afterEach(){
        System.out.println("-".repeat(80));
    }
}