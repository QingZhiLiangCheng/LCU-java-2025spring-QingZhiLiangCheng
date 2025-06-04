package cn.edu.lcu.cs.javaprogramming.io;

import cn.edu.lcu.cs.javaprogramming.collection.Score;
import cn.edu.lcu.cs.javaprogramming.collection.ScoreUtil;
import cn.edu.lcu.cs.javaprogramming.oop.User;
import lombok.Cleanup;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.JavaTimeConversionPattern;
import org.junit.jupiter.params.provider.CsvFileSource;

import java.io.*;
import java.time.LocalDate;
import java.util.Set;

/**
 * 序列化演示
 *
 * @author Ling
 */
public class SerializeDemo /*extends BaseTest*/ {
    /**
     * Score对象序列化后的文件
     */
    private static String SCORE_FILE = "target/score.obj";
    private static String USER_FILE = "target/user.obj";
    private Score zhangsanScore;

    @BeforeEach
    void beforeEach() {
        zhangsanScore = Score.builder()
                .id(1L)
                .studentNo("2020123456")
                .studentName("张三")
                .clazzName("3班")
                .ordinaryScore(85)
                .experimentScore(95)
                .midtermScore(0)
                .build();
    }

    /**
     * 序列化成绩对象到控制台
     *
     * @throws IOException
     */
    @Test
    public void serializeScore2Console() {

        // 创建对象输出流，写到标准输出设备（控制台）
        // 对象IO流只是负责将内存对象数据与串行字节流相互转换，至于字节流来自哪里，去向何方不关心
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(System.out)) {
            // 将内存对象的数据转换成字节流，写到输出流
            objectOutputStream.writeObject(zhangsanScore);
        } catch (SecurityException | IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 序列化一个成绩对象到磁盘文件
     *
     * @throws IOException
     */
    @Test
    public void serializeScore() {
        try {
            // 创建文件输出流（字节流）
            @Cleanup FileOutputStream fileOutputStream = new FileOutputStream(SCORE_FILE);
            // 创建对象输出流，与文件输出流绑定
            @Cleanup ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

            // 将内存对象的数据转换成字节流，写到输出流
            objectOutputStream.writeObject(zhangsanScore);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 反序列化，将磁盘文件中的数据恢复为内存中的对象
     *
     * @throws IOException
     * @throws ClassNotFoundException
     */
    @Test
    public void deserializeScore()  {
        try (FileInputStream fileInputStream = new FileInputStream(SCORE_FILE)) {
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            // 从输入流读取串行字节，装配成内存中的对象
            Score score = (Score) objectInputStream.readObject();
            System.out.println(score);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * 序列化一系列对象
     *
     * @throws IOException
     */
    @Test
    public void serializeScores() throws IOException {
        Set<Score> scores = ScoreUtil.getScores();

        // 创建文件输出流（字节流）与对象输出流，并绑定
        @Cleanup
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(SCORE_FILE));
        // 将内存对象的数据转换成字节流，写到输出流
        for (Score score : scores) {
            objectOutputStream.writeObject(score);
        }
    }

    /**
     * 从磁盘文件反序列化一系列对象到内存
     *
     * @throws IOException
     * @throws ClassNotFoundException
     */
    @Test
    public void deserializeScores() {
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(SCORE_FILE))) {
            Score score = null;
            while ((score = (Score) objectInputStream.readObject()) != null) {
                System.out.println(score);
            }
        } catch (EOFException e) {
            System.out.println("文件读取结束");
        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }
    }


    /**
     * 序列化，将内存中的User对象序列化到文件
     *
     * @param id
     * @param name
     * @param password
     * @param realName
     */
    @DisplayName("序列化测试，使用参数化测试")
    @ParameterizedTest
//	@CsvSource("1, lisi, 123, 李四")
    @CsvFileSource(resources = "/serialize-test.csv")
    public void serializeUser(Long id, String name, String password, String realName,
                              @JavaTimeConversionPattern("yyyy-M-d") LocalDate birthdate) {

        // 序列化对象应该实现接口 Serializable
        User user = new User(id, name, password, realName, birthdate);
        // 创建文件对象
        File file = new File(USER_FILE);

        // 创建对象输出流
        // 将对象输出流连接到文件输出流上（也可以连接到其它输出流）
        try (ObjectOutputStream outs = new ObjectOutputStream(new FileOutputStream(file))) {
            outs.writeObject(user); // 序列化内存对象到磁盘文件

            System.out.println("User对象：\t" + user);
            System.out.println("序列化文件：\t" + file.getCanonicalPath());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 反序列化，读取磁盘文件的内容，组装成内存中的对象
     */
    @Test
    public void deserializeUser() {
        // 创建对象输入流
        // 连接到文件输入流上
        try (ObjectInputStream ins = new ObjectInputStream(new FileInputStream(USER_FILE))) {
            User user = (User) ins.readObject(); // 反序列化

            System.out.println("反序列化结果：\t" + user);
        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }
    }
}
