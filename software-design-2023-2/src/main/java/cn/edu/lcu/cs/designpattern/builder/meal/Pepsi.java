package cn.edu.lcu.cs.designpattern.builder.meal;

/**
 * 百事
 */
public class Pepsi extends ColdDrink {
 
   @Override
   public float price() {
      return 35.0f;
   }
 
   @Override
   public String name() {
      return "Pepsi";
   }
}