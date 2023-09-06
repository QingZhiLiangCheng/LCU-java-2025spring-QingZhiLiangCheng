package cn.edu.lcu.cs.design_pattern.observer.theory;

public class ObserverB implements Observer {
    @Override
    public void response() {
        System.out.println(getClass().getSimpleName() + " 做出响应");

    }
}
