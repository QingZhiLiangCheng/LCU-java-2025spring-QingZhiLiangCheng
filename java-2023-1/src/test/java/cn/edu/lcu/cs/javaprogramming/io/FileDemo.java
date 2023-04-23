package cn.edu.lcu.cs.javaprogramming.io;

import cn.edu.lcu.cs.javaprogramming.BaseTest;
import lombok.Cleanup;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.io.*;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

/**
 * File演示
 *
 * @author ling
 * @date 2022/4/25 8:47
 */
public class FileDemo extends BaseTest {
    String filename = "IODemo.java";

    /**
     * 有关文件IO的一些系统属性
     */
    @Test
    void systemProperties() {
        // 当前平台的路径分隔符
        System.out.println("File.separator = " + File.separator);
        // 前边是路径分隔符，这个又是什么呢？
        System.out.println("File.pathSeparator = " + File.pathSeparator);
        // 文本文件的行分隔符
        // Windows Unix|Linux MacOS的行分隔符各有不同
        System.out.println("System.getProperty(\"line.separator\") = " + System.getProperty("line.separator"));
        // 用户的工作目录
        System.out.println("System.getProperty(\"user.dir\") = " + System.getProperty("user.dir"));
        // 用户主目录
        System.out.println("System.getProperty(\"user.home\") = " + System.getProperty("user.home"));
    }

    /**
     * File对象基础知识演示
     *
     * @param filename
     * @throws IOException
     */
    @ParameterizedTest
    @CsvSource({"D:\\FileDemo.java", "IODemo.java", "/FileDemo.java", "../FileDemo.java", "/", "/windows", "C:\\windows", "src/test/java/cn/edu/lcu/cs/javaprogramming/io/FileDemo.java"})
    void fileDemo(String filename) throws IOException {
        // 创建文件对象，无论存在与否都正确返回。
        // 名字叫File，其实也可能是目录（文件夹）
        File file = new File(filename);
        System.out.println("filename = " + filename);
        // 文件或目录的名称
        System.out.println("file.getName() = " + file.getName());
        // 构造方法传入的路径
        System.out.println("file.getPath() = " + file.getPath());
        // 绝对路径
        System.out.println("file.getAbsolutePath() = " + file.getAbsolutePath());
        // 规范路径
        System.out.println("file.getCanonicalPath() = " + file.getCanonicalPath());
        // 判断文件是否存在
        if (file.exists()) {
            System.out.println("存在");
            if (file.isFile()) {
                System.out.println("这是文件");
            }
            if (file.isDirectory()) {
                System.out.println("这是目录");
            }
            System.out.println("file.canExecute() = " + file.canExecute());
            System.out.println("file.canRead() = " + file.canRead());
            System.out.println("file.canWrite() = " + file.canWrite());
        } else {
            System.out.println("不存在");
        }
    }

    /**
     * 文件路径拼接演示。
     * 在现实编程中，尽量不直接指定绝对路径。
     * 一旦指定绝对路径，文件的位置就固定死了，无法变更位置，甚至操作系统也被固化了。
     * 应该使用动态拼接的方式产生路径。
     *
     * @param filename 文件路径：如果是相对路径，将与用户工作目录拼接成最终的绝对路径。
     * @throws IOException
     */
    @ParameterizedTest
    @CsvSource({"2020.34.csv", "/2020.34.csv", "src/main/resources/2020.34.csv"})
    void jointFilePath(String filename) throws IOException {
        // 用户工作目录，用于拼接相对路径
        System.out.println("System.getProperty(\"user.dir\") = " + System.getProperty("user.dir"));

        File file = new File(filename);
        System.out.println("filename = " + filename);
        // 规范路径
        System.out.println("file.getCanonicalPath() = " + file.getCanonicalPath());
        // 判断文件是否存在
        if (file.exists()) {
            System.out.println("存在");
        } else {
            System.out.println("不存在");
        }
    }

    /**
     * 类路径演示
     *
     * @param classpathFilename 类路径中的相对路径
     * @throws IOException
     */
    @ParameterizedTest
    @CsvSource({"2021.56.csv", "/2021.56.csv", "cn/edu/lcu/cs/javaprogramming/io/FileDemo.class"})
    void classpathDemo(String classpathFilename) throws IOException, URISyntaxException {
        // 用户工作目录，用于拼接相对路径
        System.out.println("System.getProperty(\"user.dir\") = " + System.getProperty("user.dir"));
        System.out.println("classpathFilename = " + classpathFilename);

        // 通过ClassLoader，获取指定路径在类路径中的地址
        URL url = this.getClass().getClassLoader().getResource(classpathFilename);
        System.out.println("url = " + url);

        URI uri = url.toURI();
        System.out.println("uri = " + uri);

        File file = new File(uri);
        // 规范路径
        System.out.println("file.getCanonicalPath() = " + file.getCanonicalPath());
        // 判断文件是否存在
        if (file.exists()) {
            System.out.println("存在");
        } else {
            System.out.println("不存在");
        }
    }

    /**
     * 读取字节流文件示例
     *
     * @param filename
     * @throws IOException
     */
    @ParameterizedTest
    @CsvSource({"src/main/resources/2021.56.csv"})
    void inputFile(String filename) {
        File file = new File(filename);
        if (file.exists()) {
                FileInputStream ins = null;
            try {
                ins = new FileInputStream(file);
                int bytesRead = 0;
                while ((bytesRead = ins.read()) != 1) {
                    System.out.print(bytesRead);
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            } finally {
                try {
                    ins.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }


//            FileInputStream ins = null;
//            try {
//                // 创建文件输入字节流，只能读取二进制字节
//                ins = new FileInputStream(file);
//                int b = -1;
//                // 持续读取字节，并赋值
//                // 如果读取到-1，说明文件读取结束
//                while ((b = ins.read()) != -1) {
//                    //将读取的二进制字节直接输出到控制台
//                    System.out.print(b);
//                }
//            } catch (IOException e) {
//                e.printStackTrace();
//            } finally {
//                // 无论前边有没有异常发生，本分支都会执行
//                try {
//                    // 将IO流关闭
//                    // 如果流没有正常关闭，会有资源泄漏
//                    ins.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
        } else {
            System.out.println("文件找不到：" + file.getAbsolutePath());
        }
    }

    /**
     * 读取字符流文件示例
     *
     * @param filename
     * @throws IOException
     */
    @ParameterizedTest
    @CsvSource({"src/main/resources/2020.34.csv"})
    void readFile(String filename) {
        File file = new File(filename);
        if (file.exists()) {
            FileReader reader = null;
            try {
                // 创建文件输入字符流
                reader = new FileReader(file);
                int c = -1;
                while ((c = reader.read()) != -1) {
                    System.out.print((char) c);
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                // 无论前边有没有异常发生，本分支都会执行
                try {
                    // 将IO流关闭
                    // 如果流没有正常关闭，会有资源泄漏
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } else {
            System.out.println("文件找不到：" + file.getAbsolutePath());
        }
    }

    /**
     * 读取文本文件（字符流），一次读取一行。
     * 带缓冲地读取文件。
     *
     * @param filename
     * @throws IOException
     */
    @ParameterizedTest
    @CsvSource({"src/main/resources/2020.34.csv"})
    void bufferedReadFile(String filename) {
        File file = new File(filename);
        if (file.exists()) {
            BufferedReader reader = null;
            try {
                // 创建文件输入字符流
                reader = new BufferedReader(new FileReader(file));
                String line = null;
                while ((line = reader.readLine()) != null) {
                    System.out.println(line);
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                // 无论前边有没有异常发生，本分支都会执行
                try {
                    // 将IO流关闭
                    // 如果流没有正常关闭，会有资源泄漏
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } else {
            System.out.println("文件找不到：" + file.getAbsolutePath());
        }
    }

    /**
     * 自动关闭流。
     * 使用 try-with-resources 语法自动关闭。
     *
     * @param filename
     * @throws IOException
     */
    @ParameterizedTest
    @CsvSource({"src/main/resources/2020.34.csv"})
    void autocloseFile(String filename) {
        File file = new File(filename);
        if (file.exists()) {
            // try-with-resources 语法声明并创建的对象，将来会被自动关闭。
            // 前提是该对象实现了 java.io.Closeable 接口
            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                String line = null;
                while ((line = reader.readLine()) != null) {
                    System.out.println(line);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("文件找不到：" + file.getAbsolutePath());
        }
    }

    /**
     * 自动关闭流。
     * 使用 Lombok的注解 。
     *
     * @param filename
     * @throws IOException
     */
    @ParameterizedTest
    @CsvSource({"src/main/resources/2020.34.csv"})
    void autocloseFileWithLombok(String filename) {
        File file = new File(filename);
        if (file.exists()) {
            try {
                // 使用Lombok注解自动关闭对象
                @Cleanup
                BufferedReader reader = new BufferedReader(new FileReader(file));
                String line = null;
                while ((line = reader.readLine()) != null) {
                    System.out.println(line);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("文件找不到：" + file.getAbsolutePath());
        }
    }
}
