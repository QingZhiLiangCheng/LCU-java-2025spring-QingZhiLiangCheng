package cn.edu.lcu.cs.design_pattern.visitor.computer;

public class VideoCard implements ComputerPart {
    private String name = "显卡";
    private Double price = 3599.0;
    private String description = "NVIDIA GeForce RTX2070 8GB独立显卡";

    @Override
    public void accept(Visitor visitor) {
        System.out.println(visitor.getClass().getSimpleName() + "\t访问了\t" + this.getClass().getSimpleName());
        visitor.visitVideoCard(this);
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
