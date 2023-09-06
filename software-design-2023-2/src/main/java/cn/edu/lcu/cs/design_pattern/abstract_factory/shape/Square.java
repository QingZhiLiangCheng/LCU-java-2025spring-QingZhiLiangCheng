package cn.edu.lcu.cs.design_pattern.abstract_factory.shape;

public class Square implements Shape {
 
   @Override
   public void draw() {
      System.out.println("Inside Square::draw() method.");
   }
}