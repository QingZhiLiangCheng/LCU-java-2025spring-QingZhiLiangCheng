package cn.edu.lcu.cs.designpattern.factory.mobile;

public class SamsongGalaxyZFold2Factory implements MobileFactory {

    @Override
    public Mobile build() {
        return new SamsongGalaxyZFold2();
    }

}
