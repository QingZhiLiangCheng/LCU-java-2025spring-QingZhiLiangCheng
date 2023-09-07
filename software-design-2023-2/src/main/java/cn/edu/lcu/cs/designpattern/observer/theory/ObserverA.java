package cn.edu.lcu.cs.designpattern.observer.theory;

public class ObserverA implements Observer {
    @Override
    public void response() {
        System.out.println(getClass().getSimpleName() + " 做出响应");
    }
}
