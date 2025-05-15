package cn.edu.lcu.cs.javaprogramming.collection;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class SetDemo {
    private static final int SIZE = 3;
    /**
     * 存储从文件中读取的学生姓名列表
     */
    private static List<String> names;

    /**
     * 报名列表的列表，包含多个报名列表。
     * 每个列表代表一个报名表，列表中的元素是报名信息，未过滤前可以包含重复项。
     */
    private static List<List<String>> unfilteredSignupList;

    /**
     * 在所有测试方法执行前，读取学生名单文件中的名字
     * 这个方法负责初始化名字列表，供后续测试使用
     *
     * @throws URISyntaxException 如果无法获取到文件的URI
     */
    @BeforeAll
    public static void readNames() throws URISyntaxException {
        // 定义文件名，这里假设文件位于类路径的根目录下
        String filename = "/学生名单.csv";
        // 获取文件的URI，以便后续读取文件内容
        URI uri = SetDemo.class.getResource(filename).toURI();
        try {
            // 读取文件内容，跳过第一行（通常可能是表头），并提取每行的第三个字段（这里假设是名字）
            // 注意：已注释掉的Charset.forName("GBK")部分可能是为了适应特定的文件编码，如果需要可以取消注释并指定正确的字符集
            names = Files.lines(Paths.get(uri)/*, Charset.forName("GBK")*/).skip(1)
                    .map(line -> line.split(",")[2])
                    .toList();
        } catch (IOException e) {
            // 如果在读取文件过程中发生IO异常，打印异常信息
            e.printStackTrace();
        }
    }


    /**
     * 初始化报名列表
     * 该方法在所有测试执行之前调用，用于创建一个包含随机报名项的列表
     * 列表中的每一项是一个字符串列表，代表一个用户的报名信息
     */
    @BeforeAll
    public static void signup() {
        // 创建一个随机数生成器实例
        Random random = new Random();
        // 初始化报名列表为一个容量为SIZE的ArrayList
        unfilteredSignupList = new ArrayList<>(SIZE);
        // 遍历以生成SIZE个报名表
        for (int i = 0; i < SIZE; i++) {
            // 为每个报名表创建一个新的ArrayList
            ArrayList<String> signups = new ArrayList<>();
            // 生成一个随机数r，决定当前报名表中报名信息的数量
            int r = random.nextInt(0, names.size());
            // 根据随机数r添加报名信息到当前报名表中
            for (int j = 0; j < r; j++) {
                // 从names列表中随机选择一个名称添加到报名信息中
                signups.add(names.get(random.nextInt(0, names.size())));
            }
            // 将当前报名表添加到报名列表的列表中
            unfilteredSignupList.add(signups);
        }
    }


    /**
     * 打印未过滤的报名列表
     * 此方法用于显示去重前的报名表信息，通过遍历未过滤的报名列表并打印每个报名信息
     */
    @Test
    public void printUnfilteredSignupList() {
        // 打印去重前的报名表标题
        System.out.println("去重前的报名表：");
        // 遍历未过滤的报名列表并打印每个报名信息
        unfilteredSignupList.forEach(System.out::println);
    }

    /**
     * 打印过滤过的报名列表，不包含重复项
     */
    @Test
    public void printFilteredSignupList() {
        System.out.println("去重后的报名表：");
        // TODO 打印过滤后的报名列表，不包含重复项

    }


}
