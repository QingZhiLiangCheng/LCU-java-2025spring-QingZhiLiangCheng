package cn.edu.lcu.cs.design_pattern.visitor.computer.another;

public class Memory implements ComputerPart {
    private String name = "内存";
    private Double price = 265.0;
    private String description = "16GB DDR4 高频内存";

    @Override
    public void accept(Visitor visitor) {
        System.out.println(visitor.getClass().getSimpleName() + "\t访问了\t" + this.getClass().getSimpleName());
        visitor.visit(this);
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
