package cn.edu.lcu.cs.designpattern.factory.mobile;

public class Client {
    public static void main(String[] args) {
        Mobile huaweiMate40Pro = new HuaweiMate40ProFactory().build();
        System.out.println(huaweiMate40Pro);

        Mobile samsongGalaxyZFold2 = new SamsongGalaxyZFold2Factory().build();
        System.out.println(samsongGalaxyZFold2);
    }
}
