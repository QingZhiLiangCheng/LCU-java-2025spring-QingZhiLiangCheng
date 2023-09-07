package cn.edu.lcu.cs.designpattern.visitor.computer.another;

public class PartsInfoVisitor implements Visitor {
    private StringBuilder sb = new StringBuilder();

    @Override
    public void visit(CPU cpu) {
        sb.append("\nCPU\t").append(cpu.getDescription());
    }

    @Override
    public void visit(Memory memory) {
        sb.append("\nMemory\t").append(memory.getDescription());
    }

    @Override
    public void visit(Monitor monitor) {
        sb.append("\nMonitor\t").append(monitor.getDescription());
    }

    @Override
    public void visit(HardDisk hardDisk) {
        sb.append("\nHardDisk\t").append(hardDisk.getDescription());
    }

    @Override
    public void visit(VideoCard videoCard) {
        sb.append("\nVideoCard\t").append(videoCard.getDescription());
    }

    public String getDescription() {
        return sb.toString();
    }
}

