package cn.edu.lcu.cs.designpattern.visitor.computer;

public class HardDisk implements ComputerPart {
    private String name = "硬盘";
    private Double price = 500.0;
    private String description = "256GB M.2SSD+1TB机械硬盘";

    @Override
    public void accept(Visitor visitor) {
        System.out.println(visitor.getClass().getSimpleName() + "\t访问了\t" + this.getClass().getSimpleName());
        visitor.visitHardDisk(this);
    }

    @Override
    public Double getPrice() {
        return price;
    }

    @Override
    public String getDescription() {
        return description;
    }
}