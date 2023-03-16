package cn.edu.lcu.cs.javaprogramming.oop.animal;

public abstract class Mammal extends Endotherm {

    @Override
    public void feed() {
        System.out.println("用乳汁养育后代");
    }
}
