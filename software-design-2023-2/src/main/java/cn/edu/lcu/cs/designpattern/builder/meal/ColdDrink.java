package cn.edu.lcu.cs.designpattern.builder.meal;

/**
 * 冷饮
 */
public abstract class ColdDrink implements Item {
 
    @Override
    public Packing packing() {
       return new Bottle();
    }
 
    @Override
    public abstract float price();
}