package cn.edu.lcu.cs.designpattern.visitor.theory;

public class ElementA implements Element {
    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void operationA() {
        System.out.println("元素A的操作");
    }
}
