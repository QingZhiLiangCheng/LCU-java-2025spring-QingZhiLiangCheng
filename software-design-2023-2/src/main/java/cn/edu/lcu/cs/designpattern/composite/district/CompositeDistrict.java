package cn.edu.lcu.cs.designpattern.composite.district;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 非基层行政区划，包括国、省、市级
 */
public class CompositeDistrict extends District {
    private List<District> children = new ArrayList<>();

    public CompositeDistrict(String id, String name, CompositeDistrict parent, DistrictLevel level) {
        super(id, name, parent, level);
        if (parent != null) {
            parent.add(this);
        }
    }

    public void add(District child) {
        children.add(child);
    }

    public void remove(District child) {
        children.remove(child);
    }

    public boolean contains(District child) {
        return children.contains(child);
    }

    @Override
    public void traversal() {
        System.out.println(this);
        children.forEach(District::traversal);
    }

    @Override
    public String toString() {
        String result = "";
        switch (getLevel()) {
            case PROVINCIAL:
                result += "\t";
                break;
            case MUNICIPAL:
                result += "\t\t";
                break;
            case COUNTY:
                result += "\t\t\t";
                break;
        }
        return result + super.toString();
    }

    @Override
    public Iterator iterator() {
        return null;
    }


    public class DistrictIterator implements Iterator {
        @Override
        public boolean hasNext() {
            return false;
        }

        @Override
        public Object next() {
            return null;
        }
    }

}
