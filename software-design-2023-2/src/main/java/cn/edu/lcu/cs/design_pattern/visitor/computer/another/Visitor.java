package cn.edu.lcu.cs.design_pattern.visitor.computer.another;

public interface Visitor {
    void visit(HardDisk hardDisk);

    void visit(CPU cpu);

    void visit(Memory memory);

    void visit(Monitor monitor);

    void visit(VideoCard videoCard);
}
