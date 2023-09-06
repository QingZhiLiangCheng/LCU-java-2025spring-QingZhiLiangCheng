package cn.edu.lcu.cs.design_pattern.observer.plain;

public class Client {
    public static void main(String[] args) {
        // 可观察的对象
        Savannah savannah = new Savannah(Savannah.Season.DRY);
        // 观察者
        Lion lion = new Lion();
        Antelope antelope = new Antelope();
        // 注册观察者
        savannah.addObserver(lion);
        savannah.addObserver(antelope);
        // 被观察者的状态变更被注册的观察者观察到，进行相应的操作
        savannah.change();
        System.out.println("------------------");
        savannah.change();
        System.out.println("------------------");
        savannah.change();
        System.out.println("------------------");
        savannah.change();
        System.out.println("------------------");
        savannah.change();
    }
}
