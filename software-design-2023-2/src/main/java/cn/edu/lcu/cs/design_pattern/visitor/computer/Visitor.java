package cn.edu.lcu.cs.design_pattern.visitor.computer;

public interface Visitor {
    void visitHardDisk(HardDisk hardDisk);

    void visitCPU(CPU cpu);

    void visitMemory(Memory memory);

    void visitMonitor(Monitor monitor);

    void visitVideoCard(VideoCard videoCard);
}
