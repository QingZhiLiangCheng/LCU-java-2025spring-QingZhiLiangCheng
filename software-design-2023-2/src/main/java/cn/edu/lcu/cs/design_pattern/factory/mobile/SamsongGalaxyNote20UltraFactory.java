package cn.edu.lcu.cs.design_pattern.factory.mobile;

public class SamsongGalaxyNote20UltraFactory implements MobileFactory {

    @Override
    public Mobile build() {
        return new SamsongGalaxyNote20Ultra();
    }
}
