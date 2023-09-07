package cn.edu.lcu.cs.designpattern.visitor.demo;

public class Client {
    public static void main(String[] args) {
        ObjectStructure objectStructure = new ObjectStructure();
        objectStructure.add(new ConcreteElementA());
        objectStructure.add(new ConcreteElementB());
        Visitor visitor = new ConcreteVisitorA();
        objectStructure.accept(visitor);
        System.out.println("------------------------");
        visitor = new ConcreteVisitorB();
        objectStructure.accept(visitor);
    }
}

