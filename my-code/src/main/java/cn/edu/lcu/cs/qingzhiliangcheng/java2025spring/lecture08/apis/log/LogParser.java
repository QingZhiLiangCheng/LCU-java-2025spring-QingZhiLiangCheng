package cn.edu.lcu.cs.qingzhiliangcheng.java2025spring.lecture08.apis.log;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class LogParser {

    public static LogEntry[] parseLogFileFromClasspath(String fileName) throws Exception {
        // 获取类加载器
        ClassLoader classLoader = LogParser.class.getClassLoader();

        // 从类路径中加载文件
        InputStream inputStream = classLoader.getResourceAsStream(fileName);
        if (inputStream == null) {
            throw new IllegalArgumentException("File not found: " + fileName);
        }

        // 读取文件内容
        List<LogEntry> logEntries = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8))) {
            String line;
            while ((line = reader.readLine()) != null) {
                // 解析每行日志
                String[] parts = line.split(" ", 4); // 按空格分割，最多分成3部分
                if (parts.length == 4) {
                    String timestamp = parts[0] + " " + parts[1];
                    String level = parts[2];
                    String message = parts[3];
                    logEntries.add(new LogEntry(timestamp, level, message));
                }
            }
        }

        // 将List转换为数组
        return logEntries.toArray(new LogEntry[0]);
    }

    public static void main(String[] args) {
        try {
            LogEntry[] logEntries = parseLogFileFromClasspath("system.log");
            for (LogEntry logEntry : logEntries) {
                System.out.println(logEntry);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
