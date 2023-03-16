package cn.edu.lcu.cs.javaprogramming.oop.animal;

public abstract class Fish extends Vertebrate implements Swimmable {
    public Fish() {
    }

    @Override
    public void breath() {
        System.out.println("用鳃呼吸");
    }

    /**
     * 会游泳
     * 有人将本方法命名为：swim youyong yuoyong fushui
     * 如何统一规定方法的定义，不让程序员乱改？
     */
    public void youyong() {
        System.out.println("会游泳");
    }
}
