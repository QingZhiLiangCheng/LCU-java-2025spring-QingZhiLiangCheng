package cn.edu.lcu.cs.designpattern.builder.bike;

/**
 * @version v1.0
 * @ClassName: OfoBuilder
 * @Description: ofo单车构建者，用来构建ofo单车
 * @Author: 黑马程序员
 */
public class OfoBuilder extends Builder {
    @Override
    public void buildFrame() {
        bike.setFrame("铝合金车架");
    }

    @Override
    public void buildSeat() {
        bike.setSeat("橡胶车座");
    }

    @Override
    public void buildBrand() {
        bike.setBrand("OfoBike");
    }

    @Override
    public Bike createBike() {
        return bike;
    }
}
