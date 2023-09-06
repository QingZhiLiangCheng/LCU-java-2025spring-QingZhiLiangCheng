package cn.edu.lcu.cs.architecture.mvc.usermanage.util;

import java.util.ArrayList;
import java.util.List;

public abstract class Observable {
    /**
     * 观察本主题的所有观察者
     */
    protected List<Observer> observers;

    public Observable() {
        this.observers = new ArrayList<>();
    }

    /**
     * <p>注册新观察者</p>
     *
     * @param observer
     */
    public void register(Observer observer) {
        observers.add(observer);
    }

    /**
     * <p>取消注册</p>
     *
     * @param observer
     */
    public void unregister(Observer observer) {
        observers.remove(observer);
    }

    /**
     * <p>通知所有的观察者</p>
     */
    public void notifyObservers() {
//        observers.forEach(observer -> observer.update(this));
        notifyObservers(null); // 把本身的状态作为参数通知给注册的观察者
    }


    /**
     * <p>通知所有的观察者，并传递参数</p>
     *
     * @param arg 传递的参数
     */
    public void notifyObservers(Object arg) {
        observers.forEach(observer -> observer.update(this, arg));
    }


}
