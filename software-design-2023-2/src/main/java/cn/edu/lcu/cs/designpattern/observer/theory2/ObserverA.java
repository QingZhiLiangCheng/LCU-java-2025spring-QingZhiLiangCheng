package cn.edu.lcu.cs.designpattern.observer.theory2;

import static cn.edu.lcu.cs.util.ConsoleColor.DEFAULT;
import static cn.edu.lcu.cs.util.ConsoleColor.FG_GREEN;

public class ObserverA implements Observer {
    @Override
    public void update(Observable observable) {
        update(observable, observable.getState());
    }

    @Override
    public void update(Observable observable, Object state) {
        System.out.println(FG_GREEN + "被观察对象状态发生变更，被ObserverA发现了，" + state + DEFAULT);
    }
}
