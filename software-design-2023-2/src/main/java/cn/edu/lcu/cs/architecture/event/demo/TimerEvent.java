package cn.edu.lcu.cs.architecture.event.demo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import static cn.edu.lcu.cs.architecture.event.demo.Event.Type.TIMER;

@Getter
@Setter
@ToString(callSuper = true)
public class TimerEvent extends Event {
    /**
     * 将要流逝的秒数
     */
    private int elapseSeconds;

    public TimerEvent(String message) {
        super(TIMER, message);
    }
}
