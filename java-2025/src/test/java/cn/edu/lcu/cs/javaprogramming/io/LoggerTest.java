package cn.edu.lcu.cs.javaprogramming.io;

import org.junit.jupiter.api.*;
import java.io.IOException;
import java.nio.file.*;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class LoggerTest {

    private static final String TEST_LOG_FILE = "test_log.txt";
    private Logger logger;

    @BeforeEach
    public void setUp() {
        logger = new Logger(TEST_LOG_FILE);
    }

    @AfterEach
    public void tearDown() throws IOException {
        if (Files.exists(Paths.get(TEST_LOG_FILE))) {
            Files.delete(Paths.get(TEST_LOG_FILE));
        }

        // 删除归档文件
        Files.list(Paths.get("."))
             .filter(p -> p.toString().startsWith(TEST_LOG_FILE + "."))
             .forEach(p -> {
                 try {
                     Files.delete(p);
                 } catch (IOException e) {
                     e.printStackTrace();
                 }
             });
    }

    @Test
    public void testLogWithLevels() throws IOException {
        logger.log(Logger.Level.INFO, "系统启动");
        logger.log(Logger.Level.ERROR, "发生错误");

        List<String> logs = logger.readAll();

        assertNotNull(logs);
        assertEquals(2, logs.size());
        assertTrue(logs.get(0).contains("[INFO]"));
        assertTrue(logs.get(1).contains("[ERROR]"));
    }

    @Test
    public void testAutoArchive() throws IOException {
        // 强制写入大量数据触发归档
        for (int i = 0; i < 10000; i++) {
            logger.log(Logger.Level.DEBUG, "测试日志内容" + i);
        }

        // 触发下一次写入，判断是否归档
        logger.log(Logger.Level.INFO, "应触发归档");

        boolean archived = false;
        for (int i = 1; i <= 5; i++) {
            String archiveFile = TEST_LOG_FILE + ".20241010_1.log";
            if (Files.exists(Paths.get(archiveFile))) {
                archived = true;
                break;
            }
        }

        assertTrue(archived);
    }

    @Test
    public void testClearLogs() throws IOException {
        logger.log(Logger.Level.INFO, "初始化日志");
        logger.clear();

        List<String> logs = logger.readAll();
        assertTrue(logs.isEmpty());
    }
}
