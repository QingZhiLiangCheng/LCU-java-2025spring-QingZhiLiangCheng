package cn.edu.lcu.cs.design_pattern.builder.meal;

/**
 * 蔬菜汉堡
 */
public class VegBurger extends Burger {
 
   @Override
   public float price() {
      return 25.0f;
   }
 
   @Override
   public String name() {
      return "Veg Burger";
   }
}