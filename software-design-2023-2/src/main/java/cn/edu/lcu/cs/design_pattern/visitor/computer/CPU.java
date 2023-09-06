package cn.edu.lcu.cs.design_pattern.visitor.computer;

public class CPU implements ComputerPart {
    private String name = "CPU";
    private Double price = 2719.0;
    private String description = "英特尔i7-9700";

    @Override
    public void accept(Visitor visitor) {
        System.out.println(visitor.getClass().getSimpleName() + "\t访问了\t" + this.getClass().getSimpleName());
        visitor.visitCPU(this);
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
