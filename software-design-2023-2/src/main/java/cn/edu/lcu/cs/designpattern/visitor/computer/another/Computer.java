package cn.edu.lcu.cs.designpattern.visitor.computer.another;

import java.util.ArrayList;
import java.util.List;

public class Computer {
    private List<ComputerPart> parts = new ArrayList<>();

    public void add(ComputerPart part) {
        if (part != null) {
            parts.add(part);
        }
    }

    public void remove(ComputerPart part) {
        if (part != null) {
            parts.remove(part);
        }
    }

    public void accept(Visitor visitor) {
        System.out.println(visitor.getClass().getSimpleName() + "\t访问了\t" + this.getClass().getSimpleName());
        parts.forEach(part -> part.accept(visitor));
    }

}
