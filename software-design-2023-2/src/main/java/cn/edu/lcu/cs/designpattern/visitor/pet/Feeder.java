package cn.edu.lcu.cs.designpattern.visitor.pet;

/**
 * @author Ling
 */
public interface Feeder {
    void feed(Cat cat);

    void feed(Dog dog);
}