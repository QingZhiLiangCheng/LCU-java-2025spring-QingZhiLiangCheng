package cn.edu.lcu.cs.javaprogramming.oop.animal;

public abstract class Fish extends Vertebrate {
    public Fish() {
    }

    @Override
    public void breath() {
        System.out.println("用鳃呼吸");
    }

    // 会游泳
    public void swim() {
        System.out.println("会游泳");
    }
}
