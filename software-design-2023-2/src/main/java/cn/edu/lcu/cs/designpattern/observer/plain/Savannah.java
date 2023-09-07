package cn.edu.lcu.cs.designpattern.observer.plain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Observable;

/**
 * 使用Java内置的Observable类模拟被观察对象--非洲热带大草原。
 * 但是java.util.Observable从JDK9开始被淘汰了。
 */
@Getter
@Setter
@AllArgsConstructor
public class Savannah extends Observable {
    private Season season;

    /**
     * 改变季节
     */
    public void change() {
        if (season == Season.DRY) {
            season = Season.RAINY;
        } else {
            season = Season.DRY;
        }
        // 设置修改标志为真
        setChanged();
// 通知所有的观察者，并且清除修改标志
//        notifyObservers();
        // 通知所有的观察者，并且清除修改标志；通知时可以传递参数
        notifyObservers(season);
    }

    /**
     * 旱季，雨季
     */
    public enum Season {DRY, RAINY}
}
