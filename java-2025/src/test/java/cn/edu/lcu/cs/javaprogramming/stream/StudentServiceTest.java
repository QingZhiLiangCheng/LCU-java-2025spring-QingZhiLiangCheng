package cn.edu.lcu.cs.javaprogramming.stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

/**
 * StudentServiceTest 类用于测试 StudentService 中的学生数据处理方法。
 * 该类通过 JUnit 5 编写单元测试，验证各个 Stream 操作的正确性。
 */
class StudentServiceTest {

    private StudentService studentService;
    private List<Student> students;

    /**
     * 在每个测试方法执行前初始化 StudentService 实例和学生列表。
     * 初始化包含六名学生的列表，用于后续测试。
     */
    @BeforeEach
    void setUp() {
        studentService = new StudentService();
        students = List.of(
            new Student("Alice", 20, 85.5),
            new Student("Bob", 22, 90.0),
            new Student("Charlie", 19, 78.0),
            new Student("David", 20, 92.5),
            new Student("Eve", 22, 88.0),
            new Student("Frank", 21, 85.0)
        );
    }

    /**
     * 测试 filterStudentsByAge 方法。
     * 验证筛选出年龄大于指定阈值的学生是否符合预期。
     *
     * 方法原型：
     * public List<Student> filterStudentsByAge(List<Student> students, int ageThreshold)
     *
     * 参数：
     * - students: 待筛选的学生列表
     * - ageThreshold: 年龄阈值
     *
     * 返回值：
     * 符合条件的学生列表
     */
    @Test
    void testFilterStudentsByAge() {
        List<Student> result = studentService.filterStudentsByAge(students, 20);
        assertEquals(3, result.size());
    }

    /**
     * 测试 extractScores 方法。
     * 验证提取所有学生的分数是否符合预期。
     *
     * 方法原型：
     * public List<Double> extractScores(List<Student> students)
     *
     * 参数：
     * - students: 学生列表
     *
     * 返回值：
     * 学生的分数列表
     */
    @Test
    void testExtractScores() {
        List<Double> scores = studentService.extractScores(students);
        assertTrue(scores.contains(92.5));
    }

    /**
     * 测试 sortStudentsByScoreDesc 方法。
     * 验证按分数从高到低对学生列表进行排序是否符合预期。
     *
     * 方法原型：
     * public List<Student> sortStudentsByScoreDesc(List<Student> students)
     *
     * 参数：
     * - students: 学生列表
     *
     * 返回值：
     * 按分数降序排列的学生列表
     */
    @Test
    void testSortStudentsByScoreDesc() {
        List<Student> sorted = studentService.sortStudentsByScoreDesc(students);
        assertEquals(92.5, sorted.get(0).getScore(), 0.01);
    }

    /**
     * 测试 getRankingSegment 方法。
     * 验证获取排名区间段的学生是否符合预期。
     *
     * 方法原型：
     * public List<Student> getRankingSegment(List<Student> students, int skip, int limit)
     *
     * 参数：
     * - students: 学生列表
     * - skip: 跳过前 N 个元素
     * - limit: 最多返回的元素数量
     *
     * 返回值：
     * 排名区间段的学生列表
     */
    @Test
    void testGetRankingSegment() {
        List<Student> segment = studentService.getRankingSegment(students, 1, 3);
        assertEquals(3, segment.size());
        assertEquals(90.0, segment.get(0).getScore(), 0.01);
    }

    /**
     * 测试 countStudentsByAge 方法。
     * 验证统计年龄大于指定阈值的学生人数是否符合预期。
     *
     * 方法原型：
     * public long countStudentsByAge(List<Student> students, int ageThreshold)
     *
     * 参数：
     * - students: 学生列表
     * - ageThreshold: 年龄阈值
     *
     * 返回值：
     * 符合条件的学生人数
     */
    @Test
    void testCountStudentsByAge() {
        long count = studentService.countStudentsByAge(students, 20);
        assertEquals(3, count);
    }

    /**
     * 测试 hasHighScorer 方法。
     * 验证是否存在分数高于指定阈值的学生是否符合预期。
     *
     * 方法原型：
     * public boolean hasHighScorer(List<Student> students, double scoreThreshold)
     *
     * 参数：
     * - students: 学生列表
     * - scoreThreshold: 分数阈值
     *
     * 返回值：
     * 如果存在符合条件的学生则返回 true，否则返回 false
     */
    @Test
    void testHasHighScorer() {
        boolean result = studentService.hasHighScorer(students, 90);
        assertTrue(result);
    }

    /**
     * 测试 allStudentsAboveThreshold 方法。
     * 验证所有学生是否都高于指定分数阈值是否符合预期。
     *
     * 方法原型：
     * public boolean allStudentsAboveThreshold(List<Student> students, double scoreThreshold)
     *
     * 参数：
     * - students: 学生列表
     * - scoreThreshold: 分数阈值
     *
     * 返回值：
     * 如果全部符合条件则返回 true，否则返回 false
     */
    @Test
    void testAllStudentsAboveThreshold() {
        boolean result = studentService.allStudentsAboveThreshold(students, 60);
        assertTrue(result);
    }

    /**
     * 测试 noStudentsBelowThreshold 方法。
     * 验证是否不存在分数低于指定阈值的学生是否符合预期。
     *
     * 方法原型：
     * public boolean noStudentsBelowThreshold(List<Student> students, double scoreThreshold)
     *
     * 参数：
     * - students: 学生列表
     * - scoreThreshold: 分数阈值
     *
     * 返回值：
     * 如果没有符合条件的学生则返回 true，否则返回 false
     */
    @Test
    void testNoStudentsBelowThreshold() {
        boolean result = studentService.noStudentsBelowThreshold(students, 50);
        assertTrue(result);
    }

    /**
     * 测试 calculateTotalScore 方法。
     * 验证计算所有学生的总分是否符合预期。
     *
     * 方法原型：
     * public Optional<Double> calculateTotalScore(List<Student> students)
     *
     * 参数：
     * - students: 学生列表
     *
     * 返回值：
     * 所有学生的总分，若列表为空则返回 Optional.empty()
     */
    @Test
    void testCalculateTotalScore() {
        Optional<Double> total = studentService.calculateTotalScore(students);
        assertTrue(total.isPresent());
        assertEquals(519.0, total.get(), 0.01);
    }
}