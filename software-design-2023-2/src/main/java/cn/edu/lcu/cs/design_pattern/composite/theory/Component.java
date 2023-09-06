package cn.edu.lcu.cs.design_pattern.composite.theory;

/**
 * 抽象构件类。
 * 封装子类共有方法的声明与实现。
 * 客户对抽象构件编程，无须关心具体子类是容器还是叶子。
 *
 * 2022/9/13 16:47
 *
 * @Author ling
 */
public abstract class Component {

    /**
     * 业务方法
     */
    public void operation() {
        throw new UnsupportedOperationException();
    }

    /**
     * 添加成员
     *
     * @param component
     */
    public void add(Component component) {
        throw new UnsupportedOperationException();
    }


    /**
     * 删除成员
     *
     * @param component
     */
    public void remove(Component component) {
        throw new UnsupportedOperationException();
    }

    /**
     * 获取成员
     *
     * @param index
     * @return
     */
    public Component getChild(int index) {
        throw new UnsupportedOperationException();
    }
}
