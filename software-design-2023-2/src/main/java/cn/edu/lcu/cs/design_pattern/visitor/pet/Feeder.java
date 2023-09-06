package cn.edu.lcu.cs.design_pattern.visitor.pet;

/**
 * @author Ling
 */
public interface Feeder {
    void feed(Cat cat);

    void feed(Dog dog);
}