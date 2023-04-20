package cn.edu.lcu.cs.javaprogramming.collection;

import cn.edu.lcu.cs.javaprogramming.BaseTest;
import lombok.extern.java.Log;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 用成绩集合演示Stream操作
 *
 * @author ling
 * @date 2022/4/20 0:04
 */
@Log
public class ScoreStreamDemo extends BaseTest {
    Set<Score> scores = ScoreUtil.getScores();

    /**
     * 根据ID查询第一个满足条件的实例
     *
     * @param id
     */
    @ParameterizedTest
    @ValueSource(longs = {1, -1})
    void findById(Long id) {
        Score found = null;

        // 代码填空
        //for (Score score : scores) {
        //    if (id.equals(score.getId())) {
        //        found = score;
        //        break;
        //    }
        //}

        Optional<Score> optional = scores.stream().filter(score -> id.equals(score.getId())).findFirst();
        found = optional.orElse(null);
        //found = optional.orElseThrow(NoSuchElementException::new);

        System.out.println("id = " + id);
        System.out.println("found = " + found);
    }

    /**
     * 查询所有及格的成绩，及统计及格的人数
     */
    @Test
    void findPassed() {
        // 代码填空


    }

    /**
     * 判断是否有总成绩恰好等于特定值的成绩
     *
     * @param totalScore
     */
    @ParameterizedTest
    @ValueSource(doubles = {0, 60, 100})
    void isTotalScoreAnyMatch(Double totalScore) {
        System.out.println("totalScore = " + totalScore);
        // 代码填空

    }

    /**
     * 对总成绩进行统计：数量，最大值，最小值，平均值
     */
    @Test
    void statisticsOfTotalScore() {
        //代码填空


    }

    /**
     * 查询不及格学生的姓名
     */
    @Test
    void findFailingStudentName() {
        //代码填空


    }

    /**
     * 查询不及格学生的姓名及成绩
     */
    @Test
    void findFailingStudentNameAndTotalScore() {
        //代码填空


    }

    /**
     * 先根据班级递减排序，再根据学号递减排序
     */
    @Test
    void sortByClazzAndStudentNo() {
        //代码填空

    }

    /**
     * 收集为映射
     */
    @Test
    void toMap() {
        //代码填空


    }

    /**
     * 按照条件，将流分为两个区。
     */
    @Test
    void partitioningBy() {
        //将成绩分为及格与不及格两部分
        //代码填空

    }

    /**
     * 按照某些条件分组
     */
    @Test
    void groupingBy() {
        //按照班级分组
        // 代码填空


    }

    /**
     * 返回逗号分隔的不及格学生姓名
     */
    @Test
    void csvFailingRoster() {
        // 代码填空

    }
}
