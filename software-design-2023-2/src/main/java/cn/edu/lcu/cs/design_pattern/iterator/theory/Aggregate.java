package cn.edu.lcu.cs.design_pattern.iterator.theory;

public interface Aggregate {
    void add(Object object);

    void remove(Object object);

    Iterator getIterator();
}
