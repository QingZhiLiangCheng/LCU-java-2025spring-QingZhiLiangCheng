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

        Optional<Score> optional = scores.stream()
                .filter(score -> id.equals(score.getId()))
                .findFirst();
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
        // 传统方式
//        int count = 0;
//        for (Score score : scores) {
//            if (score.getTotalScore() >= 60) {
//                System.out.println("score = " + score);
//                count++;
//            }
//        }
//        System.out.println("count = " + count);

        List<Score> passedScores = scores.stream()
                .filter(score -> score.getTotalScore() >= 60)
                .collect(Collectors.toList());

        System.out.println("passedScores.size() = " + passedScores.size());
        passedScores.forEach(System.out::println);

//        Stream<Score> scoreStream = scores.stream().filter(score -> score.getTotalScore() >= 60);
//        // count是终端操作，流被关闭了
//        long passedCount = scoreStream.count();
//        System.out.println("passedCount = " + passedCount);
//        // 流已经被前边的终端操作关闭，不能再次操作，会报异常
//        scoreStream.forEach(System.out::println);

    }

    /**
     * 判断是否有总成绩恰好等于特定值的成绩
     *
     * @param ordinaryScore
     */
    @ParameterizedTest
    @ValueSource(ints = {0, 60, 100})
    void isTotalScoreAnyMatch(Integer ordinaryScore) {
        System.out.println("ordinaryScore = " + ordinaryScore);
        // 代码填空
        boolean isFound = scores.stream()
                .anyMatch(score -> score.getOrdinaryScore().equals(ordinaryScore));

        System.out.println("isFound = " + isFound);
    }

    /**
     * 对总成绩进行统计：数量，最大值，最小值，平均值
     */
    @Test
    void statisticsOfTotalScore() {
        //代码填空
        Double max = scores.stream()
                .map(score -> score.getTotalScore())
                .max(Double::compareTo)
                .orElse(Double.MIN_VALUE);

        System.out.println("max = " + max);
        System.out.println(scores.stream()
                .map(score -> score.getTotalScore())
                .sorted()
                .collect(Collectors.toList()));

        DoubleSummaryStatistics statistics = scores.stream()
                .collect(Collectors.summarizingDouble(Score::getTotalScore));
        System.out.println("statistics.getAverage() = " + statistics.getAverage());
        System.out.println("statistics.getCount() = " + statistics.getCount());
        System.out.println("statistics.getMax() = " + statistics.getMax());
        System.out.println("statistics.getMin() = " + statistics.getMin());
        System.out.println("statistics.getSum() = " + statistics.getSum());

    }

    /**
     * 查询不及格学生的姓名
     */
    @Test
    void findFailingStudentName() {
        //代码填空
//        for (Score score : scores) {
//            if (score.getTotalScore()<60) {
//                System.out.println(score.getStudentName());
//            }
//        }


        List<String> studentNames = scores.stream()
                .filter(score -> score.getTotalScore() < 60)
                // 把流中元素的类型转换为另外一种类型，就是映射操作
                .map(score -> score.getStudentName())
                .collect(Collectors.toList());
//        studentNames.forEach(System.out::println);
        System.out.println(studentNames);
    }

    /**
     * 查询不及格学生的姓名及成绩
     */
    @Test
    void findFailingStudentNameAndTotalScore() {
        //代码填空
        List<Map<String, Object>> rows = scores.stream()
                .filter(score -> score.getTotalScore() < 60)
                .map(score -> {
                    Map<String, Object> row = new HashMap<String, Object>();
                    row.put("studentName", score.getStudentName());
                    row.put("totalScore", score.getTotalScore());
                    return row;
                })
                .collect(Collectors.toList());

        System.out.println(rows);

//        List<Object[]> objects = scores.stream()
//                .filter(score -> score.getTotalScore() < 60)
//                .map(score -> {
//                    Object[] row = new Object[2];
//                    row[0] = score.getStudentName();
//                    row[1] = score.getTotalScore();
//                    return row;
//                })
//                .collect(Collectors.toList());
//
//        objects.forEach(row -> {
//            System.out.println(row[0] + "\t" + row[1]);
//        });

    }

    /**
     * 先根据班级递减排序，再根据学号递减排序
     */
    @Test
    void sortByClazzAndStudentNo() {
        //代码填空
        scores.stream()
                .sorted(Comparator
                        // 先根据班级名称排序
                        .comparing(Score::getClazzName)
                        // 如果班级名称相同，再按照学号排序
                        .thenComparing(Score::getStudentNo)
                        // 整体顺序颠倒
                        .reversed())
                .forEach(System.out::println);
    }

    /**
     * 收集为映射
     */
    @Test
    void toMap() {
        //代码填空
        Map<Long, Score> scoreMap = scores.stream()
                // 收集为映射
                // 第一个参数为key，第二个参数为value
                // k-v均可由表达式计算得到
                // 本例中，value原样返回，没有进一步处理
                .collect(Collectors.toMap(Score::getId, score -> score));
        scoreMap.forEach((k, v) -> System.out.println(k + "\t" + v));

    }

    /**
     * 按照条件，将流分为两个区。
     */
    @Test
    void partitioningBy() {
        //将成绩分为及格与不及格两部分
        //代码填空
        Map<Boolean, List<Score>> parts = scores.stream()
                //.map(Score::getTotalScore)
                .collect(Collectors.partitioningBy(score -> score.getTotalScore() < 60));
        parts.forEach((k, v) -> System.out.println((k ? "不及格" : "及格") + "\n\t" + v));
    }

    /**
     * 按照某些条件分组
     */
    @Test
    void groupingBy() {
        //按照班级分组
        // 代码填空
        Map<String, List<Score>> groups = scores.stream()
                // 按照班级名称分组
                .collect(Collectors.groupingBy(score -> score.getClazzName()));
        groups.forEach((k, v) -> System.out.println(k + "\n\t" + v));

    }

    /**
     * 返回逗号分隔的不及格学生姓名
     */
    @Test
    void csvFailingRoster() {
        // 代码填空
        String failingRoster = scores.stream()
                // 保留不及格的成绩
                .filter(score -> score.getTotalScore() < 60)
                // 成绩流转换为姓名组成的字符串流
                .map(Score::getStudentName)
                // 字符串连接操作，可指定前缀与后缀
                .collect(Collectors.joining(", ", "不及格人员名单\n[", "]"));
        System.out.println(failingRoster);
    }
}
