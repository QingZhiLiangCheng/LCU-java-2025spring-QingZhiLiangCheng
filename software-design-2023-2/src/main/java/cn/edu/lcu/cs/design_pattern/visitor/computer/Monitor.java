package cn.edu.lcu.cs.design_pattern.visitor.computer;

public class Monitor implements ComputerPart {
    private String name = "显示器";
    private Double price = 1399.0;
    private String description = "戴尔UltraSharpU2417H";

    @Override
    public void accept(Visitor visitor) {
        System.out.println(visitor.getClass().getSimpleName() + "\t访问了\t" + this.getClass().getSimpleName());
        visitor.visitMonitor(this);
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
