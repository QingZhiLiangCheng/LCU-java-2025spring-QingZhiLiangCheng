package cn.edu.lcu.cs.design_pattern.builder.meal;

/**
 * 食物条目
 */
public interface Item {
   public String name();
   public Packing packing();
   public float price();    
}