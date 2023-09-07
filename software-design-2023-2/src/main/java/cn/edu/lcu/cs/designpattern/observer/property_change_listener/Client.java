package cn.edu.lcu.cs.designpattern.observer.property_change_listener;

/**
 * @author ling
 * @date 2022/10/10 0:29
 */
public class Client {
    public static void main(String[] args) {
        Person lisi = new Person("lisi", 100.);

        lisi.addPropertyChangeListener(new PersonPropertyListener());

        // 属性值变了，触发一次事件
        lisi.setWeight(101.);
        // 属性的值没有变化，不会触发事件
        lisi.setWeight(101.);
        // 属性值变了，触发一次事件
        lisi.setWeight(102.);
    }
}
