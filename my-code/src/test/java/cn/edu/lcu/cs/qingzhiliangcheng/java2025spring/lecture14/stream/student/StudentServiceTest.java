package cn.edu.lcu.cs.qingzhiliangcheng.java2025spring.lecture14.stream.student;

import static org.junit.jupiter.api.Assertions.*;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class StudentServiceTest {

    private StudentService studentService;
    private List<Student> students;

    @BeforeEach
    void setUp() {
        // 初始化学生服务和测试用的学生数据列表
        studentService = new StudentService();
        students = studentService.readStudentsFromCsv("Java成绩单-2021级.csv");
    }

    /**
     * 测试方法：验证CSV文件是否成功读取学生数据
     * 验证内容：
     * 1. 学生列表不为null
     * 2. 学生列表不为空
     * 3. 学生数量为78
     */
    @Test
    void testReadStudentsFromCsv() {
        assertNotNull(students);
        assertFalse(students.isEmpty());
        assertEquals(78, students.size());
    }

    /**
     * 测试方法：获取所有学生的姓名
     * 验证内容：
     * 1. 返回的姓名列表不为null
     * 2. 姓名列表大小与原始学生列表一致
     */
    @Test
    void testGetAllStudentNames() {
        List<String> names = studentService.getAllStudentNames(students);
        assertNotNull(names);
        assertEquals(78, names.size());
    }

    /**
     * 测试方法：统计学生总数
     * 验证内容：
     * 1. 返回的学生总数与原始列表数量一致
     */
    @Test
    void testGetStudentCount() {
        long count = studentService.getStudentCount(students);
        assertEquals(78, count);
    }

    /**
     * 测试方法：计算总成绩平均值
     * 验证内容：
     * 1. 平均分大于0
     */
    @Test
    void testGetAverageTotalScore() {
        double average = studentService.getAverageTotalScore(students);
        assertTrue(average > 0);
    }

    /**
     * 测试方法：按班级对学生进行分组
     * 验证内容：
     * 1. 分组结果Map不为null
     * 2. 班级数量为2
     */
    @Test
    void testGroupByClass() {
        Map<String, List<Student>> studentsByClass = studentService.groupByClass(students);
        assertNotNull(studentsByClass);
        assertEquals(2, studentsByClass.size());
    }

    /**
     * 测试方法：按性别对学生进行分组
     * 验证内容：
     * 1. 分组结果Map不为null
     * 2. 性别分类数量为2
     */
    @Test
    void testGroupByGender() {
        Map<String, List<Student>> studentsByGender = studentService.groupByGender(students);
        assertNotNull(studentsByGender);
        assertEquals(2, studentsByGender.size());
    }

    /**
     * 测试方法：按总成绩对学生进行降序排序
     * 验证内容：
     * 1. 排序后的列表不为null
     * 2. 列表大小与原始数据一致
     * 3. 数据按总成绩正确降序排列
     */
    @Test
    void testSortByTotalScoreDesc() {
        List<Student> sortedStudents = studentService.sortByTotalScoreDesc(students);
        assertNotNull(sortedStudents);
        assertEquals(78, sortedStudents.size());

        for (int i = 0; i < sortedStudents.size() - 1; i++) {
            assertTrue(sortedStudents.get(i).getTotalScore() >=
                    sortedStudents.get(i + 1).getTotalScore());
        }
    }

    /**
     * 测试方法：获取总成绩排名前10的学生
     * 验证内容：
     * 1. 返回列表不为null
     * 2. 返回列表数量为10
     * 3. 数据按总成绩正确降序排列
     */
    @Test
    void testGetTop10Students() {
        List<Student> top10Students = studentService.getTop10Students(students);
        assertNotNull(top10Students);
        assertEquals(10, top10Students.size());

        for (int i = 0; i < top10Students.size() - 1; i++) {
            assertTrue(top10Students.get(i).getTotalScore() >=
                    top10Students.get(i + 1).getTotalScore());
        }
    }

    /**
     * 测试方法：获取总成绩排名后10的学生
     * 验证内容：
     * 1. 返回列表不为null
     * 2. 返回列表数量为10
     * 3. 数据按总成绩正确升序排列
     */
    @Test
    void testGetBottom10Students() {
        List<Student> bottom10Students = studentService.getBottom10Students(students);
        assertNotNull(bottom10Students);
        assertEquals(10, bottom10Students.size());

        for (int i = 0; i < bottom10Students.size() - 1; i++) {
            assertTrue(bottom10Students.get(i).getTotalScore() <=
                    bottom10Students.get(i + 1).getTotalScore());
        }
    }

    /**
     * 测试方法：查找缺考（期末成绩为0）的学生
     * 验证内容：
     * 1. 缺考学生列表不为null
     * 2. 缺考人数为1
     */
    @Test
    void testFindAbsentStudents() {
        List<Student> absentStudents = studentService.findAbsentStudents(students);
        assertNotNull(absentStudents);
        assertEquals(1, absentStudents.size());
    }

    /**
     * 测试方法：统计各班级学生的平均成绩
     * 验证内容：
     * 1. 返回的平均成绩Map不为null
     * 2. 包含两个班级的平均成绩
     */
    @Test
    void testCalculateAverageScoreByClass() {
        Map<String, Double> averageScores = studentService.calculateAverageScoreByClass(students);
        assertNotNull(averageScores);
        assertEquals(2, averageScores.size());
    }

    /**
     * 测试方法：判断是否存在总成绩超过95分的学生
     * 验证内容：
     * 1. 返回值为true，表示存在成绩超过95分的学生
     */
    @Test
    void testHasOutstandingStudent() {
        boolean hasOutstanding = studentService.hasOutstandingStudent(students);
        assertTrue(hasOutstanding);
    }
}
