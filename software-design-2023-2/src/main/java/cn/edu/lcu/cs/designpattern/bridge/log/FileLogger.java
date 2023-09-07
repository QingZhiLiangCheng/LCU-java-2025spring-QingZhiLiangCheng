package cn.edu.lcu.cs.designpattern.bridge.log;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDateTime;

import static cn.edu.lcu.cs.designpattern.bridge.log.Logger.LoggerLevel.*;

/**
 * @Description 文件日志记录器
 * @Author Ling
 * @Date 2021/9/28 20:45
 * @Version 1.0
 */
public class FileLogger implements Logger {
    private String fileName;

    public FileLogger() {
        // 缺省日志文件名，存放于当前目录
        fileName = "logger.log";
    }

    public FileLogger(String fileName) {
        this.fileName = fileName;
    }

    private void init() throws IOException {
        // 保证上级目录存在
        Path parentPath = Paths.get(fileName, "..");
        if (Files.notExists(parentPath)) {
            Files.createDirectories(parentPath);
        }
    }

    @Override
    public void error(String msg) {
        log(ERROR, msg);
    }

    @Override
    public void info(String msg) {
        log(INFO, msg);
    }

    @Override
    public void warn(String msg) {
        log(WARN, msg);
    }

    @Override
    public void debug(String msg) {
        log(DEBUG, msg);
    }

    /**
     * 日志消息的格式固定死了，如果想改变格式，需要修改旧代码，不符合开闭原则。
     *
     * @param level
     * @param msg
     */
    @Override
    public void log(LoggerLevel level, String msg) {
        String formattedMsg = LocalDateTime.now() + "\t" + level + "\t" + msg + "\n";
        try {
            Files.write(Paths.get(fileName), formattedMsg.getBytes(StandardCharsets.UTF_8), StandardOpenOption.CREATE, StandardOpenOption.APPEND);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
