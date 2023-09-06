package cn.edu.lcu.cs.architecture.pipe.updatefile;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

/**
 * 用Stream演示管道操作，更简洁。
 */
public class StreamDemo {
    public static void main(String[] args) {
        try {
            // 从类路径中加载文件，转换为URL
            // file:/C:/Users/Ling/IdeaProjects/design_pattern_software_architecture_maven_demo/target/classes/architecture/pipe/legacy_files/Sale1.txt
            URL url = StreamDemo.class.getResource("/architecture/pipe/legacy_files/Sale1.txt");
            // 转换为URI，并由此创建一个Path对象
            // C:\Users\Ling\IdeaProjects\design_pattern_software_architecture_maven_demo\target\classes\architecture\pipe\legacy_files\Sale1.txt
            Path path = Paths.get(url.toURI());
            List<String> lines = Files.readAllLines(path); // 读取所有行
            lines.stream()
                    // 当前行所有2位年份添加前缀19
                    .map(line -> line.replaceAll(" ([\\d]{2})-", " 19$1-"))
                    // 当前行字符串替换
                    .map(line -> line.replaceAll("Republic of China", "Taiwan"))
                    .sorted() // 排序
                    .forEach(System.out::println); // 输出到控制台
        } catch (IOException | URISyntaxException e) {
            e.printStackTrace();
        }
    }
}
