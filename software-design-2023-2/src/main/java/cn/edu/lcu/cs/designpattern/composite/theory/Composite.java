package cn.edu.lcu.cs.designpattern.composite.theory;

import java.util.ArrayList;
import java.util.List;

/**
 * 容器构件
 * 2022/9/13 17:01
 *
 * @Author ling
 */
public class Composite extends Component {
    private List<Component> children = new ArrayList<>();

    @Override
    public void operation() {
        children.forEach(Component::operation);
    }

    @Override
    public void add(Component component) {
        children.add(component);
    }

    @Override
    public void remove(Component component) {
        children.remove(component);
    }

    @Override
    public Component getChild(int index) {
        return children.get(index);
    }
}
