package cn.edu.lcu.cs.designpattern.visitor.computer;

public class PartsInfoVisitor implements Visitor {
    private StringBuilder sb = new StringBuilder();

    @Override
    public void visitCPU(CPU cpu) {
        sb.append("\nCPU\t").append(cpu.getDescription());
    }

    @Override
    public void visitMemory(Memory memory) {
        sb.append("\nMemory\t").append(memory.getDescription());
    }

    @Override
    public void visitMonitor(Monitor monitor) {
        sb.append("\nMonitor\t").append(monitor.getDescription());
    }

    @Override
    public void visitHardDisk(HardDisk hardDisk) {
        sb.append("\nHardDisk\t").append(hardDisk.getDescription());
    }

    @Override
    public void visitVideoCard(VideoCard videoCard) {
        sb.append("\nVideoCard\t").append(videoCard.getDescription());
    }

    public String getDescription() {
        return sb.toString();
    }
}

