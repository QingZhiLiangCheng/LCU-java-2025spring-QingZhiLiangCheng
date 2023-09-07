package cn.edu.lcu.cs.designpattern.composite.district2;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

/**
 * 行政级别，用单一结点完成。
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = {"id", "parent"})
public class District {
    private String id;
    private String name;
    private District parent;
    private List<District> children;

    /**
     * 行政区级别，国家，省级，市级，县级
     */
    private DistrictLevel level;

    public District(String id, String name, DistrictLevel level) {
        this.id = id;
        this.name = name;
        this.level = level;
    }

    /**
     * 递归遍历当前结点为起点的子树。
     * 遍历时仅打印结点，没有通用性。
     * todo 应该引入迭代器模式
     */
    public void traversal() {
        print();
        if (hasChildren()) {
            children.forEach(District::traversal);
        }
    }

    public void print() {
        System.out.println(toString());
    }

    public void add(District child) {
        if (children == null) {
            children = new ArrayList<>();
        }
        child.setParent(this);
        children.add(child);
    }

    public boolean hasChildren() {
        if (children != null && !children.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }

    public void removeChild(District child) {
        if (hasChild(child)) {
            if (child.hasChildren()) {
                List<District> grandChildren = child.getChildren();
                int size = grandChildren.size();
                for (int i = 0; i < size; i++) {
                    child.removeChild(grandChildren.get(0));
                }
            }
            children.remove(child);
        }
    }

    public boolean hasChild(District child) {
        if (hasChildren() && children.contains(child)) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 行政级别：国家，省，市，县
     */
    public enum DistrictLevel {
        NATIONAL, PROVINCIAL, MUNICIPAL, COUNTY
    }


}
