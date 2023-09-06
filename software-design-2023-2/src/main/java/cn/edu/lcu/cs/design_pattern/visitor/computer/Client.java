package cn.edu.lcu.cs.design_pattern.visitor.computer;

public class Client {
    public static void main(String[] args) {
        Computer computer = getComputer();

        PriceVisitor priceVisitor = new PriceVisitor();
        // 计算机接受价格访问者访问，保存各部件价格，及计算总价格
        computer.accept(priceVisitor);
        System.out.println("电脑各部件价格");
        // 遍历打印访问者获取的各部件价格，使用Lambda表达式
        priceVisitor.getPartPrices().forEach((key, value)->System.out.println(key + "\t" + value));
        // 打印访问者获取的总价格
        System.out.println("电脑总价格\t" + priceVisitor.getTotalPrice());

        // 另外一个访问者，只关心部件的描述信息
        PartsInfoVisitor infoVisitor = new PartsInfoVisitor();
        computer.accept(infoVisitor);
        System.out.println("电脑基本信息" + infoVisitor.getDescription());

    }

    private static Computer getComputer() {
        Computer computer = new Computer();
        computer.add(new CPU());
        computer.add(new HardDisk());
        computer.add(new Memory());
        computer.add(new Monitor());
        computer.add(new VideoCard());
        return computer;
    }
}
