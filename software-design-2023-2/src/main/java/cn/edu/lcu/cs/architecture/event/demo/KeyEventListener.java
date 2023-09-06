package cn.edu.lcu.cs.architecture.event.demo;

import static cn.edu.lcu.cs.util.ConsoleColor.*;

public class KeyEventListener implements EventListener {
    @Override
    public void process(Event event) {
        if (event instanceof KeyEvent) {
            System.out.println(FG_RED + event + DEFAULT);
        }
    }
}
