package cn.edu.lcu.cs.design_pattern.visitor.demo;

import java.util.ArrayList;
import java.util.List;

/**
 * 对象结构角色
 */
public class ObjectStructure {
    private List<Element> elements = new ArrayList<>();

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
