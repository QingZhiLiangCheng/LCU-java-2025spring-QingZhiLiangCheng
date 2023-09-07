package cn.edu.lcu.cs.designpattern.builder.bike;

/**
 * @version v1.0
 * @ClassName: Client
 * @Author: 黑马程序员
 */
public class Client {
    public static void main(String[] args) {
        //创建指挥者对象
        Director director = new Director(new MobileBuilder());
        //让指挥者指挥组装自行车
        Bike bike = director.construct();
        System.out.println(bike);

        director = new Director(new OfoBuilder());
        bike = director.construct();
        System.out.println(bike);
    }
}
