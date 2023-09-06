package cn.edu.lcu.cs.architecture.event.demo;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.Instant;

@Getter
@Setter
@ToString(exclude = {"type", "eventSource", "when"})
public class Event {
    /**
     * 事件类型
     */
    private Type type;
    /**
     * 事件描述
     */
    private String message;
    /**
     * 事件发生的时间
     */
    private Instant when;
    /**
     * 事件源
     */
    private EventSource eventSource;

    public Event(Type type, String message) {
        this.type = type;
        this.message = message;
        when = Instant.now();
    }

    /**
     * 事件类型：键盘事件，鼠标事件，定时器事件
     */
    public enum Type {KEY, MOUSE, TIMER}
}
