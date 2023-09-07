package cn.edu.lcu.cs.designpattern.abstract_factory.shape;

public abstract class AbstractFactory {
   public abstract Color getColor(String color);
   public abstract Shape getShape(String shape) ;
}