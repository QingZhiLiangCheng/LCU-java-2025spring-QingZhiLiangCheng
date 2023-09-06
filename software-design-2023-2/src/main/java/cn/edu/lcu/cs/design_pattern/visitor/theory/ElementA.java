package cn.edu.lcu.cs.design_pattern.visitor.theory;

public class ElementA implements Element {
    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void operationA() {
        System.out.println("元素A的操作");
    }
}
