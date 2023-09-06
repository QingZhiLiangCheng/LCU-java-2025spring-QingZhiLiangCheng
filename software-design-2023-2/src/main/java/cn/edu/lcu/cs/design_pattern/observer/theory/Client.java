package cn.edu.lcu.cs.design_pattern.observer.theory;

/**
 * 观察者模式演示
 */
public class Client {
    public static void main(String[] args) {
        Subject subject = new ConcreteSubject();
        Observer obs1 = new ObserverA();
        Observer obs2 = new ObserverB();
        subject.add(obs1);
        subject.add(obs2);
        subject.notifyObservers();

    }
}
