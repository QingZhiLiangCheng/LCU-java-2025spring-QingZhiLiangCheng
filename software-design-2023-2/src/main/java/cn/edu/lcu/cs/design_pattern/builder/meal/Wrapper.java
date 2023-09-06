package cn.edu.lcu.cs.design_pattern.builder.meal;

/**
 * 纸盒包装（食品）
 */
public class Wrapper implements Packing {
 
   @Override
   public String pack() {
      return "Wrapper";
   }
}