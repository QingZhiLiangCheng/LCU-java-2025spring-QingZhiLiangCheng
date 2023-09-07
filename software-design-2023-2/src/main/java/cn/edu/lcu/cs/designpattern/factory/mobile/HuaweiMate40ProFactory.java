package cn.edu.lcu.cs.designpattern.factory.mobile;

public class HuaweiMate40ProFactory implements MobileFactory {

    @Override
    public Mobile build() {
        return new HuaweiMate40Pro();
    }
}
