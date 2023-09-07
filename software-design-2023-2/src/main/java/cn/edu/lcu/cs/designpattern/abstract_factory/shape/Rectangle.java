package cn.edu.lcu.cs.designpattern.abstract_factory.shape;

public class Rectangle implements Shape {
 
   @Override
   public void draw() {
      System.out.println("Inside Rectangle::draw() method.");
   }
}