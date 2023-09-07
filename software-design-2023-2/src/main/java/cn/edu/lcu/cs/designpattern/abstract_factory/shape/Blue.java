package cn.edu.lcu.cs.designpattern.abstract_factory.shape;

public class Blue implements Color {
 
   @Override
   public void fill() {
      System.out.println("Inside Blue::fill() method.");
   }
}