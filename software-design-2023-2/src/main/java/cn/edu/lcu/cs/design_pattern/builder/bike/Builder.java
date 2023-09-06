package cn.edu.lcu.cs.design_pattern.builder.bike;

/**
 * @version v1.0
 * @ClassName: Builder
 * @Author: 黑马程序员
 */
public abstract class Builder {

    //声明Bike类型的变量，并进行赋值
    protected Bike bike = new Bike();

    public abstract void buildFrame();

    public abstract void buildSeat();

    public abstract void buildBrand();

    //构建自行车的方法
    public abstract Bike createBike();
}
