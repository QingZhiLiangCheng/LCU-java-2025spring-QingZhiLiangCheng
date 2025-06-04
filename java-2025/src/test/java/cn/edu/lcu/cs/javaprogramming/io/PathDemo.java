package cn.edu.lcu.cs.javaprogramming.io;

import cn.edu.lcu.cs.javaprogramming.BaseTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class PathDemo extends BaseTest {

    /**
     * 演示Path接口
     *
     * @param folderName
     * @throws IOException
     */
    @ParameterizedTest
    @ValueSource(strings = {"./myfile.txt", "d:/a/b/c"})
    public void path(String folderName) throws IOException {
        Path path = Paths.get(folderName);
        System.out.println("path = " + path);
        System.out.println("path.getFileName() = " + path.getFileName());
        System.out.println("path.getNameCount() = " + path.getNameCount());
        System.out.println("path.getParent() = " + path.getParent());
        System.out.println("path.toAbsolutePath() = " + path.toAbsolutePath());
        System.out.println("path.toFile().getCanonicalPath() = " + path.toFile().getCanonicalPath());
        System.out.println("path.toFile().exists() = " + path.toFile().exists());
        System.out.println("Files.exists(path) = " + Files.exists(path));
    }

    /**
     * 测试路径解析
     *
     * @param src
     * @param dst
     */
    @ParameterizedTest
    @CsvSource("doc/1/2/3/4, 5/6")
    public void resolvePath(String src, String dst) {
        Path source = Paths.get(src);
        Path target = Paths.get(dst);
        System.out.println("source = " + source);
        System.out.println("target = " + target);

        // 返回路径上最后一个值，不管它是文件还是文件夹
        System.out.println("source.getFileName() = " + source.getFileName());
        System.out.println("target.getFileName() = " + target.getFileName());

        // 路径解析：如果目标是绝对路径，返回目标路径；如果目标是相对路径，将目标拼接到源路径上
        System.out.println("source.resolve(target) = " + source.resolve(target));

        // 路径解析：用目标路径替换源路径的末端路径，拼接成新路径。目标路径与源路径末端被替换的部分是兄弟
        System.out.println("source.resolveSibling(target) = " + source.resolveSibling(target));
    }

    /**
     * 探测文件的文档类型MIME
     *
     * @throws IOException
     */
    @ParameterizedTest
    @ValueSource(strings = {"xxx.jpg", "zzz.docx", "yyy.doc"})
    public void contentType(String fileName) throws IOException {
        Path path = Paths.get(fileName);
        // 获取文档类型，其实文件可以不存在，只给出文件名即可
        System.out.println("Content Type of " + path + " is " + Files.probeContentType(path));
    }

    /**
     * 遍历目录及后代目录
     *
     * @param folderName
     * @throws IOException
     */
    @ParameterizedTest
    @ValueSource(strings = ".")
    public void dir(String folderName) throws IOException {
        Path path = Paths.get(folderName);
        //if (path.toFile().isDirectory()) {
        if (Files.isDirectory(path)) {
            // 返回目录stream，延迟加载
            Stream<Path> paths = Files.walk(path /* , FileVisitOption.FOLLOW_LINKS */);
            // （深度）遍历目录树，打印目录或文件的名称
            paths
                    // 保留*.java文件名
                    .filter(p -> p.toString().endsWith(".java"))
                    .forEach(System.out::println);
        }
    }

    /**
     * 如果指定文件路径的上级目录不存在，就创建它；然后写文件。
     *
     * @param fileName
     * @throws IOException
     */
    @ParameterizedTest
    @ValueSource(strings = {"D:/a/b/c/log/logger.log"})
    void makeParentDirsAndWriteFile(String fileName) throws IOException {
        // 获取当前路径的上级目录
        Path parentPath = Paths.get(fileName, "..");
        // 如果上级目录不存在，就创建它
        if (Files.notExists(parentPath)) {
            // 创建上级目录，及祖先目录（如果祖先目录不存在的话），注意与createDirectorie()的区别
            Files.createDirectories(parentPath);
        }
        // 获取当前文件的路径
        Path path = Paths.get(fileName);


        // 将要写入文件的文本内容
        String line = "文件路径：" + path.toFile().getCanonicalPath();
        List<String> lines = Arrays.asList(line);
        String content = line + System.getProperty("line.separator");

        // 写文件，追加方式，如果不存在就创建它。
        // 可以写二进制字节，需要指定字节数组。
        // 如果写入的是文本，需要事先指定行分隔符。
        //Files.write(path, content.getBytes(StandardCharsets.UTF_8), StandardOpenOption.APPEND, StandardOpenOption.CREATE);

        // 也可以写文本，需要指定字符串的列表，每个字符串都是文本文件中的一行，不需要指定行分隔符
        Files.write(path, lines, StandardOpenOption.APPEND, StandardOpenOption.CREATE);
    }

}
