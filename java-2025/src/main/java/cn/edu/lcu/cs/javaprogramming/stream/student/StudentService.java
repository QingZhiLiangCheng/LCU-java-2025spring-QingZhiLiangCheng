package cn.edu.lcu.cs.javaprogramming.stream.student;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 学生服务类，提供学生数据处理相关功能
 */
public class StudentService {

    /**
     * 从类路径下的CSV文件读取学生数据
     *
     * @param classpathFilePath 类路径下的CSV文件路径
     * @return 包含学生对象的列表
     */
    public List<Student> readStudentsFromCsv(String classpathFilePath) {
        List<Student> students = new ArrayList<>();

        try (InputStream is = getClass().getClassLoader().getResourceAsStream(classpathFilePath);
             BufferedReader br = new BufferedReader(new InputStreamReader(is, StandardCharsets.UTF_8))) {

            if (is == null) {
                throw new FileNotFoundException("找不到类路径下的文件: " + classpathFilePath);
            }

            String line;
            boolean skipHeader = true;

            while ((line = br.readLine()) != null) {
                // 跳过表头行
                if (skipHeader) {
                    skipHeader = false;
                    continue;
                }

                String[] values = line.split(",");
                if (values.length >= 9) {
                    Student student = new Student();
                    student.setId(Integer.parseInt(values[0]));
                    student.setClassName(values[1]);
                    student.setStudentId(values[2]);
                    student.setName(values[3]);
                    student.setDailyScore(Double.parseDouble(values[4]));
                    student.setMidExam(Double.parseDouble(values[5]));
                    student.setFinalExam(Double.parseDouble(values[6]));
                    student.setTotalScore(Double.parseDouble(values[7]));
                    student.setGender("Ů".equals(values[8]) ? "女" : "男");

                    students.add(student);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return students;
    }


    /**
     * 获取所有学生的姓名
     *
     * @param students 学生列表
     * @return 包含所有学生姓名的列表
     */
    public List<String> getAllStudentNames(List<Student> students) {
        return students.stream()
                .map(Student::getName)
                .collect(Collectors.toList());
    }

    /**
     * 获取学生总数
     *
     * @param students 学生列表
     * @return 学生数量
     */
    public long getStudentCount(List<Student> students) {
        return students.stream()
                .count();
    }

    /**
     * 获取学生总成绩的平均值
     *
     * @param students 学生列表
     * @return 总成绩的平均分，若无学生则返回0.0
     */
    public double getAverageTotalScore(List<Student> students) {
        return students.stream()
                .mapToDouble(Student::getTotalScore)
                .average()
                .orElse(0.0);
    }

    /**
     * 按班级对学生进行分组
     *
     * @param students 学生列表
     * @return 班级为键、学生列表为值的Map
     */
    public Map<String, List<Student>> groupByClass(List<Student> students) {
        return students.stream()
                .collect(Collectors.groupingBy(Student::getClassName));
    }

    /**
     * 按性别对学生进行分组
     *
     * @param students 学生列表
     * @return 性别为键、学生列表为值的Map
     */
    public Map<String, List<Student>> groupByGender(List<Student> students) {
        return students.stream()
                .collect(Collectors.groupingBy(Student::getGender));
    }

    /**
     * 按总成绩对学生进行降序排序
     *
     * @param students 学生列表
     * @return 按总成绩降序排列的学生列表
     */
    public List<Student> sortByTotalScoreDesc(List<Student> students) {
        return students.stream()
                .sorted((s1, s2) -> Double.compare(s2.getTotalScore(), s1.getTotalScore()))
                .collect(Collectors.toList());
    }

    /**
     * 获取总成绩排名前10的学生
     *
     * @param students 学生列表
     * @return 总成绩排名前10的学生列表
     */
    public List<Student> getTop10Students(List<Student> students) {
        return students.stream()
                .sorted((s1, s2) -> Double.compare(s2.getTotalScore(), s1.getTotalScore()))
                .limit(10)
                .collect(Collectors.toList());
    }

    /**
     * 获取总成绩排名后10的学生
     *
     * @param students 学生列表
     * @return 总成绩排名后10的学生列表
     */
    public List<Student> getBottom10Students(List<Student> students) {
        return students.stream()
                .sorted(Comparator.comparingDouble(Student::getTotalScore))
                .limit(10)
                .collect(Collectors.toList());
    }

    /**
     * 查找缺考（期末成绩为0）的学生
     *
     * @param students 学生列表
     * @return 缺考学生列表
     */
    public List<Student> findAbsentStudents(List<Student> students) {
        return students.stream()
                .filter(s -> s.getFinalExam() == 0.0)
                .collect(Collectors.toList());
    }

    /**
     * 统计各班级学生的平均成绩
     *
     * @param students 学生列表
     * @return 班级为键、平均成绩为值的Map
     */
    public Map<String, Double> calculateAverageScoreByClass(List<Student> students) {
        return students.stream()
                .collect(Collectors.groupingBy(
                        Student::getClassName,
                        Collectors.averagingDouble(Student::getTotalScore)
                ));
    }

    /**
     * 判断是否存在总成绩超过95分的学生
     *
     * @param students 学生列表
     * @return 若存在总成绩超过95分的学生则返回true，否则返回false
     */
    public boolean hasOutstandingStudent(List<Student> students) {
        return students.stream()
                .anyMatch(s -> s.getTotalScore() > 95.0);
    }
}

