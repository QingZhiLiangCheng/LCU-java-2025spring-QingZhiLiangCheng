package cn.edu.lcu.cs.javaprogramming.stream;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * StreamExample 类演示了 Java 8 Stream API 的常见用法。
 * 通过操作学生列表，展示了筛选、映射、排序、聚合等流式操作。
 */
public class StreamExample {

    /**
     * 程序入口点。
     *
     * @param args 命令行参数（未使用）
     */
    public static void main(String[] args) {

        // 初始化学生数据集合
        List<Student> students = Arrays.asList(
            new Student("Alice", 20, 85.5),
            new Student("Bob", 22, 90.0),
            new Student("Charlie", 19, 78.0),
            new Student("David", 20, 92.5),
            new Student("Eve", 22, 88.0),
            new Student("Frank", 21, 85.0)
        );

        // 打印所有学生信息
        System.out.println("所有学生信息:");
        students.forEach(System.out::println);

        /*
          filter 操作：
          筛选年龄大于 20 的学生。

          参数：s -> s.getAge() > 20 —— 条件谓词
          返回值：符合条件的学生列表
         */
        List<Student> filteredStudents = students.stream()
                .filter(s -> s.getAge() > 20)
                .collect(Collectors.toList());
        System.out.println("\n年龄大于 20 的学生:");
        filteredStudents.forEach(System.out::println);

        /*
          map 操作：
          将学生对象转换为其分数属性。

          参数：Student::getScore —— 映射函数
          返回值：包含所有学生成绩的列表
         */
        List<Double> scores = students.stream()
                .map(Student::getScore)
                .collect(Collectors.toList());
        System.out.println("\n所有学生的分数列表:");
        System.out.println(scores);

        /*
          sorted 操作：
          根据学生分数从高到低排序。

          参数：(s1, s2) -> Double.compare(s2.getScore(), s1.getScore()) —— 自定义比较器
          返回值：按分数降序排列的学生列表
         */
        List<Student> sortedByScore = students.stream()
                .sorted((s1, s2) -> Double.compare(s2.getScore(), s1.getScore()))
                .toList();
        System.out.println("\n按分数从高到低排序:");
        sortedByScore.forEach(System.out::println);

        /*
          limit 和 skip 操作组合：
          获取第 2 到第 4 名学生（跳过第一名，取三个）。

          参数：skip(1) 表示跳过第一个元素；limit(3) 表示最多取三个元素
          返回值：排名 2-4 的学生列表
         */
        List<Student> top3From2nd = students.stream()
                .sorted((s1, s2) -> Double.compare(s2.getScore(), s1.getScore()))
                .skip(1)
                .limit(3)
                .toList();
        System.out.println("\n第 2 到第 4 名学生:");
        top3From2nd.forEach(System.out::println);

        /*
          count 操作：
          统计年龄大于 20 的学生人数。

          参数：s -> s.getAge() > 20 —— 过滤条件
          返回值：匹配条件的学生数量
         */
        long countOver20 = students.stream()
                .filter(s -> s.getAge() > 20)
                .count();
        System.out.println("\n年龄大于 20 的学生人数: " + countOver20);

        /*
          anyMatch 操作：
          检查是否有至少一个学生的分数超过 90。

          参数：s -> s.getScore() > 90 —— 匹配条件
          返回值：是否存在满足条件的学生
         */
        boolean hasHighScorer = students.stream()
                .anyMatch(s -> s.getScore() > 90);
        System.out.println("是否有学生分数超过 90? " + hasHighScorer);

        /*
          allMatch 操作：
          检查是否所有学生的分数都高于 60。

          参数：s -> s.getScore() > 60 —— 匹配条件
          返回值：是否所有学生都满足条件
         */
        boolean allAbove60 = students.stream()
                .allMatch(s -> s.getScore() > 60);
        System.out.println("所有学生分数是否都高于 60? " + allAbove60);

        /*
          noneMatch 操作：
          检查是否没有学生的分数低于 50。

          参数：s -> s.getScore() < 50 —— 匹配条件
          返回值：是否没有学生满足条件
         */
        boolean noFailures = students.stream()
                .noneMatch(s -> s.getScore() < 50);
        System.out.println("是否没有人不及格? " + noFailures);

        /*
          reduce 操作：
          计算所有学生的总分。

          参数：Double::sum —— 累加函数
          返回值：Optional<Double> 类型的总分结果
         */
        Optional<Double> totalScore = students.stream()
                .map(Student::getScore)
                .reduce(Double::sum);
        totalScore.ifPresent(score -> System.out.println("学生总分为: " + score));
    }
}