package cn.edu.lcu.cs.designpattern.factory.mobile;

public class HuaweiNova7ProFactory implements MobileFactory {

    @Override
    public Mobile build() {
        return new HuaweiNova7Pro();
    }
}
