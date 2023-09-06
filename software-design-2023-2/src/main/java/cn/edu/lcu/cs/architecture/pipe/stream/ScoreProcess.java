package cn.edu.lcu.cs.architecture.pipe.stream;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * 用Java Stream操作处理成绩数据
 *
 * @Author Ling
 * @Date 2021/11/19 21:52
 * @Version 1.0
 */
public class ScoreProcess {
    private static final String FILE_NAME = "/architecture/《Java与面向对象技术》成绩单.csv";

    public static void main(String[] args) throws URISyntaxException, IOException {
        // 获取类路径中资源文件的路径
        Path path = Paths.get(ScoreProcess.class.getResource(FILE_NAME).toURI());
        // 读取所有行并转换为Stream<String>，采用延迟加载策略。
        Files.lines(path)
                // 跳过1行（标题行）
                .skip(1)
                // 流变换，拆分逗号分隔的一行数据为字符串数组，Stream<String[]>
                // 序号,姓名,学号,班级,平时成绩,期中成绩,项目成绩,期末成绩,总成绩
                .map(line -> line.split(","))
                // 流过滤，保留总成绩低于70分的记录
                .filter(cols -> {
                    double totalScore = Double.parseDouble(cols[cols.length - 1]);
                    if (totalScore < 70) {
                        return true;
                    } else {
                        return false;
                    }
                })
                // 流变换，从字符串数组中提取姓名
                .map(cols -> cols[1])
                // 流变换，将姓名第2个字更换为 某
                .map(username -> {
                    char[] chars = username.toCharArray();
                    chars[1] = '某';
                    return chars;
                })
                // 终端操作，遍历并打印流中数据，流被关闭
                .forEach(System.out::println);
    }
}
