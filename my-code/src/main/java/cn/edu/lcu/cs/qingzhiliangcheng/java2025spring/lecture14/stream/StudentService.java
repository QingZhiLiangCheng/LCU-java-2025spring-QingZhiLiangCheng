package cn.edu.lcu.cs.qingzhiliangcheng.java2025spring.lecture14.stream;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * StudentService 类提供了一系列基于 Java Stream API 的学生数据处理方法。
 * 该类包含对学生列表的过滤、转换、排序、统计等常用操作。
 */
public class StudentService {

    /**
     * 过滤出年龄大于指定阈值的学生。
     *
     * @param students     学生列表
     * @param ageThreshold 年龄阈值
     * @return 符合条件的学生列表
     */
    public List<Student> filterStudentsByAge(List<Student> students, int ageThreshold) {
//        ArrayList<Student> list = new ArrayList<>();
//        for (Student student : students) {
//            if (student.getAge() > ageThreshold) {
//                list.add(student);
//            }
//        }
//        return list;


        // 使用流处理来过滤学生列表，保留年龄大于指定阈值的学生
        return students.stream()
                .filter(s -> s.getAge() > ageThreshold)
                .toList();
//                .collect(Collectors.toList());
    }


    /**
     * 提取所有学生的分数。
     *
     * @param students 学生列表
     * @return 学生的分数列表
     */
    public List<Double> extractScores(List<Student> students) {
        // 使用Java Stream API从学生列表中提取分数
        return students.stream()
                .map(Student::getScore)
//                .map(student -> student.getScore()+10)
                .collect(Collectors.toList());
    }


    /**
     * 按照分数从高到低对学生列表进行排序。
     *
     * @param students 学生列表
     * @return 按分数降序排列的学生列表
     */
    public List<Student> sortStudentsByScoreDesc(List<Student> students) {
        // 使用Stream API对学生列表进行排序
        return students.stream()
                // 根据学生分数进行降序比较
                .sorted(Comparator.comparingDouble(Student::getScore).reversed())
                // 将排序后的流转换为列表
                .toList();
    }


    /**
     * 获取排名区间段的学生，按分数降序排列后取指定范围内的学生。
     *
     * @param students 学生列表
     * @param skip     跳过前 N 个元素
     * @param limit    最多返回的元素数量
     * @return 排名区间段的学生列表
     */
    public List<Student> getRankingSegment(List<Student> students, int skip, int limit) {
        // 对学生列表按照分数进行降序排序，并根据skip和limit参数获取指定区间的学生列表
        return students.stream()
                .sorted(Comparator.comparingDouble(Student::getScore).reversed())
                .skip(skip)
                .limit(limit)
                .toList();
    }


    /**
     * 统计年龄大于指定阈值的学生人数。
     *
     * @param students     学生列表
     * @param ageThreshold 年龄阈值
     * @return 符合条件的学生人数
     */
    public long countStudentsByAge(List<Student> students, int ageThreshold) {
        // 使用Java 8的Stream API过滤并统计满足条件的学生人数
        return students.stream()
                .filter(s -> s.getAge() > ageThreshold)
                .count();
    }


    /**
     * 判断是否存在分数高于指定阈值的学生。
     *
     * @param students       学生列表
     * @param scoreThreshold 分数阈值
     * @return 如果存在符合条件的学生则返回 true，否则返回 false
     */
    public boolean hasHighScorer(List<Student> students, double scoreThreshold) {
        // 使用流处理，判断任何学生是否满足分数高于阈值的条件
        return students.stream()
                .anyMatch(s -> s.getScore() > scoreThreshold);
    }


    /**
     * 判断所有学生是否都高于指定分数阈值。
     *
     * @param students       学生列表
     * @param scoreThreshold 分数阈值
     * @return 如果全部符合条件则返回 true，否则返回 false
     */
    public boolean allStudentsAboveThreshold(List<Student> students, double scoreThreshold) {
        // 使用Java Stream API检查所有学生的分数是否都高于指定阈值
        return students.stream()
                .allMatch(s -> s.getScore() > scoreThreshold);
    }


    /**
     * 判断是否不存在分数低于指定阈值的学生。
     *
     * @param students       学生列表
     * @param scoreThreshold 分数阈值
     * @return 如果没有符合条件的学生则返回 true，否则返回 false
     */
    public boolean noStudentsBelowThreshold(List<Student> students, double scoreThreshold) {
        // 使用流处理，检查所有学生分数是否都高于指定阈值
        return students.stream()
                .noneMatch(s -> s.getScore() < scoreThreshold);
    }


    /**
     * 计算所有学生的总分。
     *
     * @param students 学生列表
     * @return 所有学生的总分，若列表为空则返回 Optional.empty()
     */
    public Optional<Double> calculateTotalScore(List<Student> students) {
        // 使用Java 8 Stream API计算所有学生的总分
        // map方法提取每个学生的分数，reduce方法将所有分数相加
        return students.stream()
                .map(Student::getScore)
                .reduce(Double::sum);
    }

}
