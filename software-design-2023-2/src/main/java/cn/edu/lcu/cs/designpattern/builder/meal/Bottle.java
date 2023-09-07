package cn.edu.lcu.cs.designpattern.builder.meal;

/**
 * 瓶装（食物）
 */
public class Bottle implements Packing {
 
   @Override
   public String pack() {
      return "Bottle";
   }
}