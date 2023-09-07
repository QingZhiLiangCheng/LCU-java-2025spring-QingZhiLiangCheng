package cn.edu.lcu.cs.designpattern.iterator.theory;

public interface Aggregate {
    void add(Object object);

    void remove(Object object);

    Iterator getIterator();
}
