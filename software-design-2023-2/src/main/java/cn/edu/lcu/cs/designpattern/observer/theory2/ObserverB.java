package cn.edu.lcu.cs.designpattern.observer.theory2;

import static cn.edu.lcu.cs.util.ConsoleColor.DEFAULT;
import static cn.edu.lcu.cs.util.ConsoleColor.FG_RED;

public class ObserverB implements Observer {
    private Observable observable;

    public ObserverB() {
    }

    public ObserverB(Observable observable) {
        this.observable = observable;
        observable.register(this); // 将自己主动注册到被观察者
    }

    @Override
    public void update(Observable observable) {
        update(observable, observable.getState());
    }

    @Override
    public void update(Observable observable, Object state) {
        System.out.println(FG_RED + "被观察对象状态发生变更，被ObserverB发现了，" + state + DEFAULT);
    }

    public Observable getObservable() {
        return observable;
    }

    public void setObservable(Observable observable) {
        this.observable = observable;
    }
}
