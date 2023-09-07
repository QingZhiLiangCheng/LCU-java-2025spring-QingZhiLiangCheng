package cn.edu.lcu.cs.designpattern.visitor.theory;

public class ElementB implements Element {
    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void operationB() {
        System.out.println("元素B的操作");
    }
}
