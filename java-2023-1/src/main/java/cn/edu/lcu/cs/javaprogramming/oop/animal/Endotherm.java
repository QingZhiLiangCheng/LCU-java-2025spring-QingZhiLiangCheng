package cn.edu.lcu.cs.javaprogramming.oop.animal;

/**
 * 恒温动物类，包括哺乳动物与鸟类
 */


public abstract class Endotherm extends Vertebrate {

    @Override
    public void breath() {
        System.out.println("用肺呼吸");
    }
}
