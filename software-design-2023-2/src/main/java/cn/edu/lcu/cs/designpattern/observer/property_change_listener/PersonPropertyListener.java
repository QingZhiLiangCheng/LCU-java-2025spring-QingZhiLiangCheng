package cn.edu.lcu.cs.designpattern.observer.property_change_listener;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

/**
 * @author ling
 * @date 2022/10/10 0:26
 */
public class PersonPropertyListener implements PropertyChangeListener {

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if ("weight".equals(evt.getPropertyName())) {
            System.out.printf("体重又变了：%f --> %f\n", evt.getOldValue(), evt.getNewValue());
        }
    }
}
