package cn.edu.lcu.cs.architecture.event.demo;

import cn.edu.lcu.cs.util.ConsoleColor;

import static cn.edu.lcu.cs.util.ConsoleColor.*;

public class TimerEventListener implements EventListener {
    @Override
    public void process(Event event) {
        if (event.getType() == Event.Type.TIMER) {
            System.out.println(FG_GREEN + event + DEFAULT);
        }
    }
}
