package cn.edu.lcu.cs.qingzhilicangcheng.java2025spring.lecture08.apis.log;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

class LogEntry {
    private LocalDateTime timestamp;
    private String level;
    private String message;

    public LogEntry(String timestamp, String level, String message) {
        this.timestamp = LocalDateTime.parse(timestamp, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        this.level = level;
        this.message = message;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public String getLevel() {
        return level;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return timestamp.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")) + " " + level + " " + message;
    }
}
