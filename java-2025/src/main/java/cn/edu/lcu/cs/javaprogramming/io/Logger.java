package cn.edu.lcu.cs.javaprogramming.io;

import java.io.*;
import java.nio.file.*;
import java.text.SimpleDateFormat;
import java.util.*;

public class Logger {
    private final String logFilePath;
    private final long maxFileSize; // 归档阈值，默认1MB
    private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public enum Level {
        DEBUG, INFO, WARN, ERROR
    }

    public Logger(String logFilePath) {
        this(logFilePath, 1024 * 1024); // 默认1MB
    }

    public Logger(String logFilePath, long maxFileSize) {
        this.logFilePath = logFilePath;
        this.maxFileSize = maxFileSize;
    }

    /**
     * 获取日志文件的绝对路径
     */
    public String getLogFileAbsolutePath() {
        return Paths.get(logFilePath).toAbsolutePath().toString();
    }


    /**
     * 写入带级别的日志
     */
    public void log(Level level, String message) throws IOException {
        rotateLogIfNecessary(); // 判断是否需要归档

        try (BufferedWriter writer = new BufferedWriter(
                new FileWriter(logFilePath, true))) { // 追加模式
            String timestamp = sdf.format(new Date());
            writer.write(String.format("[%s] [%s] %s", timestamp, level, message));
            writer.newLine();
        }
    }

    /**
     * 自动归档逻辑：如果文件超过阈值，则重命名并备份
     */
    private void rotateLogIfNecessary() throws IOException {
        Path path = Paths.get(logFilePath);
        if (!Files.exists(path)) return;

        if (Files.size(path) >= maxFileSize) {
            int index = 1;
            String archiveFileName = logFilePath + "." + sdf.format(new Date()) + "_" + index + ".log";
            Path archivePath = Paths.get(archiveFileName);

            while (Files.exists(archivePath)) {
                index++;
                archiveFileName = logFilePath + "." + sdf.format(new Date()) + "_" + index + ".log";
                archivePath = Paths.get(archiveFileName);
            }

            Files.move(path, archivePath);
        }
    }

    /**
     * 读取所有日志内容
     */
    public List<String> readAll() throws IOException {
        if (!Files.exists(Paths.get(logFilePath))) {
            return Collections.emptyList();
        }
        return Files.readAllLines(Paths.get(logFilePath));
    }

    /**
     * 清空日志文件
     */
    public void clear() throws IOException {
        try (BufferedWriter writer = new BufferedWriter(
                new FileWriter(logFilePath))) {
            writer.write(""); // 覆盖清空
        }
    }

    /**
     * 日志文件是否存在
     */
    public boolean exists() {
        return Files.exists(Paths.get(logFilePath));
    }
}
