package cn.edu.lcu.cs.designpattern.observer.plain;

import cn.edu.lcu.cs.util.ConsoleColor;

import java.util.Observable;
import java.util.Observer;

/**
 * 观察者类
 */
public class Lion implements Observer {
    /**
     * 当被观察对象状态变化时自动调用本方法
     *
     * @param observable 被观察对象
     * @param arg        传递的参数
     */
    @Override
    public void update(Observable observable, Object arg) {
        // 通过传递的参数获取数据
        Savannah.Season season = (Savannah.Season) arg;
        switch (season) {
            case DRY:
                System.out.println(ConsoleColor.FG_YELLOW + "旱季到了，猎物跑光了，狮子也离开草原");
                break;
            case RAINY:
                System.out.println(ConsoleColor.FG_GREEN + "雨季到了，草原到处是猎物，狮子跑去猎杀");
                break;
        }
    }
}
