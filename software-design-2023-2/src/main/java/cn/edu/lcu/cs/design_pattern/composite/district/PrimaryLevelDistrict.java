package cn.edu.lcu.cs.design_pattern.composite.district;

import java.util.Iterator;

/**
 * 初级（基层）行政区划，叶子节点，没有孩子节点
 */
public class PrimaryLevelDistrict extends District {
    public PrimaryLevelDistrict(String id, String name, CompositeDistrict parent, DistrictLevel level) {
        super(id, name, parent, level);
        if (parent != null) {
            parent.add(this);
        }
    }

    @Override
    public void traversal() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        return "\t\t\t" + super.toString();
    }

    @Override
    public Iterator iterator() {
        return null;
    }
}
