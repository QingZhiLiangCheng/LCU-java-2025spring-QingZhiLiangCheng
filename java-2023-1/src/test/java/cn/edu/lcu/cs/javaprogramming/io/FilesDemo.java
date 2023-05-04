package cn.edu.lcu.cs.javaprogramming.io;

import cn.edu.lcu.cs.javaprogramming.BaseTest;
import lombok.Cleanup;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.*;
import java.util.stream.Stream;

/**
 * Files工具类演示
 *
 * @author ling
 * @date 2022/4/25 22:04
 */
class FilesDemo extends BaseTest {

    /**
     * 文件复制
     *
     * @param srcFileName
     * @param dstFileName
     * @throws IOException
     */
    @ParameterizedTest
    @CsvSource({"src/main/resources/2020.34.csv,target/new.csv"})
    void copy(String srcFileName, String dstFileName) throws IOException {
        Path copied = Files.copy(Path.of(srcFileName), Path.of(dstFileName), StandardCopyOption.REPLACE_EXISTING);
        System.out.println("copied = " + copied);
    }

    /**
     * 读取网络文件
     *
     * @param urlString
     * @param dstDirectory
     * @throws IOException
     */
    @ParameterizedTest
    @CsvSource({"http://ee-c.lcu.edu.cn/,target"})
    void httpCopy(String urlString, String dstDirectory) throws IOException {
        URL url = new URL(urlString);
        Path path = Path.of(dstDirectory, "index.html");
        System.out.println("path = " + path);
        @Cleanup InputStream ins = url.openStream();
        long copiedAmount = Files.copy(ins, path, StandardCopyOption.REPLACE_EXISTING);
        System.out.println("copiedAmount = " + copiedAmount);
    }


    /**
     * 根据学生姓名，从文本文件中模糊查询 <br>
     * 行格式（以制表符分隔\t）：<br>
     * 序号,学号,姓名,性别,班级,,
     *
     * @param fileName
     */
    @ParameterizedTest
    @CsvSource({"classpath:2020.34.csv, 赵", "classpath:/2020.34.csv, 朱", "src/main/resources/2020.34.csv, 张"})
    public void findStudentFromFileLikely(String fileName, String username) throws IOException {
        File file = FileUtil.getFile(fileName);
        if (file.exists() && file.isFile()) {
            // 一次性读取文本文件的所有行，返回stream。
            Stream<String> lines = Files.lines(file.toPath());
            lines
                    // 根据条件过滤，即模糊查询
                    .filter(line -> line.contains(username))
                    .forEach(System.out::println);
        }
    }

    /**
     * 模拟DOS命令 copy con xxx.txt ,从标准输入设备（控制台）读取字符，写到文件，Ctrl+Z结束。
     *
     * @throws IOException
     */
    @ParameterizedTest
    @ValueSource(strings = {"target/copycon.txt"})
    public void copyCon(String pathName) throws IOException {
        Path path = Paths.get(pathName);
        // 复制控制台的内容到路径
        Files.copy(System.in, path, StandardCopyOption.REPLACE_EXISTING);
    }

    /**
     * 模拟Dos命令type，显示文本文件到控制台
     *
     * @throws IOException
     * @throws URISyntaxException
     */
    @ParameterizedTest
    @ValueSource(strings = {"target/copycon.txt", "classpath:/2020.34.csv"})
    public void type(String pathName) throws IOException, URISyntaxException {
        Path path = null;
        // 如果文件名前缀是 classpath: ，就把类路径转换成绝对路径
        String prefix = "classpath:";
        if (pathName.startsWith(prefix)) {
            // 通常各种配置文件都是放在类路径中的
            // 把前缀去掉
            pathName = pathName.substring(prefix.length());
            // 从类路径中加载资源，并转换为Path
            URL url = this.getClass().getResource(pathName);
            path = Paths.get(url.toURI());
        } else {
            path = Paths.get(pathName);
        }
        Files.copy(path, System.out);
    }

}