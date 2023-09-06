package cn.edu.lcu.cs.basic.relationship;

import java.util.ArrayList;
import java.util.List;

public class Family {
    private Child child;

    public Child getChild() {
        return child;
    }

    public void setChild(Child child) {
        this.child = child;
    }

    public List<Child> getChildren() {
        return children;
    }

    public void setChildren(List<Child> children) {
        this.children = children;
    }

    private List<Child> children = new ArrayList<Child>();
}
