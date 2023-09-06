package cn.edu.lcu.cs.architecture.event.demo;

import cn.edu.lcu.cs.util.ConsoleColor;

public class MouseEventListener implements EventListener {
    @Override
    public void process(Event event) {
        if (event instanceof MouseEvent) {
            System.out.println(ConsoleColor.FG_BLUE + event + ConsoleColor.DEFAULT);
        }
    }
}
