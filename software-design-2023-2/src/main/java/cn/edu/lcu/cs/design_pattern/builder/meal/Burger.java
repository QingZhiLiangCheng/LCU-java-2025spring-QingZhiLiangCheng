package cn.edu.lcu.cs.design_pattern.builder.meal;

/**
 * 汉堡
 */
public abstract class Burger implements Item {
 
   @Override
   public Packing packing() {
      return new Wrapper();
   }
 
   @Override
   public abstract float price();
}