package cn.edu.lcu.cs.designpattern.visitor.theory;

public class Client {
    public static void main(String[] args) {
        VisitorA visitorA = new VisitorA();
        VisitorB visitorB = new VisitorB();

        ObjectStructure elements = getObjectStructure();
        elements.accept(visitorA);
        elements.accept(visitorB);

    }

    private static ObjectStructure getObjectStructure() {
        ObjectStructure elements = new ObjectStructure();
        elements.add(new ElementA());
        elements.add(new ElementB());
        return elements;
    }
}
