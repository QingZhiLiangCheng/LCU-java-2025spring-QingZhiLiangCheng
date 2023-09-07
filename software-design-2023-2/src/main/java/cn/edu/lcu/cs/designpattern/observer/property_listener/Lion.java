package cn.edu.lcu.cs.designpattern.observer.property_listener;

import cn.edu.lcu.cs.util.ConsoleColor;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

/**
 * 观察者类
 */
public class Lion implements PropertyChangeListener {
    // 监听器对象的其它属性与操作，略

    /**
     * 当被监听对象属性变更时，本方法被调用
     *
     * @param evt 封装了属性名称、旧值、新值
     */
    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        String propertyName = evt.getPropertyName(); // 属性名称
        Plain.Season newSeason = (Plain.Season) evt.getNewValue(); // 属性新值
        Plain.Season oldSeason = (Plain.Season) evt.getOldValue(); // 属性旧值
        System.out.println(propertyName + "\t" + oldSeason + "\t--->\t" + newSeason);
        switch (newSeason) {
            case DRY:
                System.out.println(ConsoleColor.FG_YELLOW + "旱季到了，猎物跑光了，狮子也离开草原");
                break;
            case RAINY:
                System.out.println(ConsoleColor.FG_GREEN + "雨季到了，草原到处是猎物，狮子跑去猎杀");
                break;
        }
    }
}
