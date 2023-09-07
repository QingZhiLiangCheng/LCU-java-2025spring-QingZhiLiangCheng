package cn.edu.lcu.cs.designpattern.iterator.theory;

public interface Iterator {
    boolean hasNext();

    Object first();

    Object next();
}
