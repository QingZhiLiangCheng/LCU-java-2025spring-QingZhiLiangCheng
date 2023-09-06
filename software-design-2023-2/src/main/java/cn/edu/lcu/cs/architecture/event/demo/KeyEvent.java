package cn.edu.lcu.cs.architecture.event.demo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import static cn.edu.lcu.cs.architecture.event.demo.Event.Type.KEY;

@Getter
@Setter
@ToString(callSuper = true)
public class KeyEvent extends Event {
    private char character;

    public KeyEvent(String message) {
        super(KEY, message);
    }
}
