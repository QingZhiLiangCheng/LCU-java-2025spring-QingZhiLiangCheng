package cn.edu.lcu.cs.design_pattern.abstract_factory.shape;

public class Green implements Color {
 
   @Override
   public void fill() {
      System.out.println("Inside Green::fill() method.");
   }
}