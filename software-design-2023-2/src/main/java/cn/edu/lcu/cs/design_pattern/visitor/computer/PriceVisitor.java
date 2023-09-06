package cn.edu.lcu.cs.design_pattern.visitor.computer;

import java.util.HashMap;
import java.util.Map;

public class PriceVisitor implements Visitor {
    private double totalPrice = 0;

    private Map<String, Double> partPrices = new HashMap<>();

    public double getTotalPrice() {
        return totalPrice;
    }

    public Map<String, Double> getPartPrices() {
        return partPrices;
    }

    @Override
    public void visitHardDisk(HardDisk hardDisk) {
        // 年终大促，硬盘9折
        double price = hardDisk.getPrice() * 0.9;
        totalPrice += price;
        partPrices.put("HardDisk", price);
    }

    @Override
    public void visitCPU(CPU cpu) {
        // 年终大促，CPU 5折
        double price = cpu.getPrice() * 0.5;
        totalPrice += price;
        partPrices.put("CPU", price);
    }

    @Override
    public void visitMemory(Memory memory) {
        // 内存利润太低，原价，不打折
        double price = memory.getPrice();
        totalPrice += price;
        partPrices.put("Memory", price);
    }

    @Override
    public void visitMonitor(Monitor monitor) {
        // 年终大促，显示器85折
        double price = monitor.getPrice() * 0.85;
        totalPrice += price;
        partPrices.put("Monitor", price);
    }

    @Override
    public void visitVideoCard(VideoCard videoCard) {
        // 年终大促，显卡85折
        double price = videoCard.getPrice() * 0.85;
        totalPrice += price;
        partPrices.put("VideoCard", price);
    }
}
