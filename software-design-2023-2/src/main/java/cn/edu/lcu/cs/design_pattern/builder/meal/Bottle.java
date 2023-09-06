package cn.edu.lcu.cs.design_pattern.builder.meal;

/**
 * 瓶装（食物）
 */
public class Bottle implements Packing {
 
   @Override
   public String pack() {
      return "Bottle";
   }
}