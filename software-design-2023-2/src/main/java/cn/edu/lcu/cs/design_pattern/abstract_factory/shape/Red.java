package cn.edu.lcu.cs.design_pattern.abstract_factory.shape;

public class Red implements Color {
 
   @Override
   public void fill() {
      System.out.println("Inside Red::fill() method.");
   }
}