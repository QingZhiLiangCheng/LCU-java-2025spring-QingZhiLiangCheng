package cn.edu.lcu.cs.design_pattern.visitor.theory;

import cn.edu.lcu.cs.util.StackTraceUtil;

public class VisitorA implements Visitor {
    @Override
    public void visit(ElementA element) {
        StackTraceUtil.printStackTrace();
        System.out.println("VisitorA访问元素A");
        element.operationA();
    }

    @Override
    public void visit(ElementB element) {
        System.out.println("VisitorA访问元素B");
        element.operationB();
    }
}
