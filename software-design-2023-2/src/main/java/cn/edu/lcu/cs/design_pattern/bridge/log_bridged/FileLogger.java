package cn.edu.lcu.cs.design_pattern.bridge.log_bridged;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

import static cn.edu.lcu.cs.designpattern.bridge.log_bridged.Logger.LoggerLevel.*;

/**
 * @Description 文件日志记录器
 * @Author Ling
 * @Date 2021/9/28 20:45
 * @Version 1.0
 */
public class FileLogger implements Logger {
    private String fileName;

    private LogMsgFormatter formatter;

    public FileLogger(String fileName, LogMsgFormatter formatter) {
        this.fileName = fileName;
        this.formatter = formatter;
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
     * 调用格式化器的方法，将原始消息格式化，并追加到日志文件。
     *
     * @param level
     * @param msg
     */
    @Override
    public void log(LoggerLevel level, String msg) {
//        String formattedMsg = LocalDateTime.now() + "\t" + level + "\t" + msg + "\n";
        // 格式化日志消息，并添加一个行分隔符
        String formattedMsg = formatter.format(level, msg) + System.getProperty("line.separator");
        try {
            Files.write(Paths.get(fileName), formattedMsg.getBytes(StandardCharsets.UTF_8), StandardOpenOption.CREATE, StandardOpenOption.APPEND);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
