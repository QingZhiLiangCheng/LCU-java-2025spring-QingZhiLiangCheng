package cn.edu.lcu.cs.designpattern.visitor.theory;

import java.util.ArrayList;
import java.util.List;

/**
 * 访问者模式中的对象结构，管理元素集合，可以依次让这些元素接受访问者的访问。
 */
public class ObjectStructure {
    private List<Element> elements = new ArrayList<>();

    /**
     * 依次让每个元素接受访问者的访问
     *
     * @param visitor
     */
    public void accept(Visitor visitor) {
        elements.forEach(element -> element.accept(visitor));
    }

    public void add(Element element) {
        elements.add(element);
    }

    public void remove(Element element) {
        elements.remove(element);
    }

}
