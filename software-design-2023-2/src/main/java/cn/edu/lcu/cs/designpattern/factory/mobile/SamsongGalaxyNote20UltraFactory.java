package cn.edu.lcu.cs.designpattern.factory.mobile;

public class SamsongGalaxyNote20UltraFactory implements MobileFactory {

    @Override
    public Mobile build() {
        return new SamsongGalaxyNote20Ultra();
    }
}
