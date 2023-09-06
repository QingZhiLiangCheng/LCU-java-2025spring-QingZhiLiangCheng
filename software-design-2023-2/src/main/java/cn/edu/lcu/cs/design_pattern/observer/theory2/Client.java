package cn.edu.lcu.cs.design_pattern.observer.theory2;

import java.time.Instant;

/**
 * 观察者模式演示
 */
public class Client {
    public static void main(String[] args) {
        Observable subject = new Subject();
        ObserverA observerA = new ObserverA();
        subject.register(observerA); // 由客户程序注册观察者
        ObserverB observerB = new ObserverB(subject); // 由观察者自己主动注册

        // 只要被观察者状态变更，观察者的update方法被自动隐式调用
        subject.setState("状态变更：" + Instant.now());
        System.out.println("---------------");
        subject.setState("状态变更：" + Instant.now());

//        subject.notifyObservers(); // 客户程序不负责分发通知
//        observerA.update(subject); // 更不能由客户程序显式调用观察者
//        subject.notifyObservers("some argument");
    }
}
