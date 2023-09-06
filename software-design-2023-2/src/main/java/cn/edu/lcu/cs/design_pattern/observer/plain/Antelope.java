package cn.edu.lcu.cs.design_pattern.observer.plain;

import cn.edu.lcu.cs.util.ConsoleColor;

import java.util.Observable;
import java.util.Observer;

/**
 * 观察者羚羊，观察草原状态的变化。
 */
public class Antelope implements Observer {
    @Override
    public void update(Observable observable, Object arg) {
        // 通过被观察对象获取数据
        Savannah plain = (Savannah) observable;
        switch (plain.getSeason()) {
            case DRY:
                System.out.println(ConsoleColor.FG_YELLOW + "旱季到了，草都枯黄了，羚羊离开草原");
                break;
            case RAINY:
                System.out.println(ConsoleColor.FG_GREEN + "雨季到了，到处是青草，羚羊来到草原生宝宝");
                break;
        }
    }
}
