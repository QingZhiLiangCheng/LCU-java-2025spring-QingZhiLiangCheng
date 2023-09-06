package cn.edu.lcu.cs.architecture.event.demo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import static cn.edu.lcu.cs.architecture.event.demo.Event.Type.MOUSE;

@Setter
@Getter
@ToString(callSuper = true)
public class MouseEvent extends Event {
    /**
     * 鼠标坐标
     */
    private int x;
    private int y;

    public MouseEvent(String message) {
        super(MOUSE, message);
    }
}
