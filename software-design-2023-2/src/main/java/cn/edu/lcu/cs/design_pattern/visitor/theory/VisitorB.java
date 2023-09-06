package cn.edu.lcu.cs.design_pattern.visitor.theory;

public class VisitorB implements Visitor {
    @Override
    public void visit(ElementA element) {
        System.out.println("VisitorB访问元素A");
        element.operationA();
    }

    @Override
    public void visit(ElementB element) {
        System.out.println("VisitorB访问元素B");
        element.operationB();
    }
}

