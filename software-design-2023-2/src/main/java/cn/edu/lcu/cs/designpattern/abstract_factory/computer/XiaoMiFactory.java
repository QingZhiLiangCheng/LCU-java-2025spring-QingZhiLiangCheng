package cn.edu.lcu.cs.designpattern.abstract_factory.computer;

public class XiaoMiFactory implements AbstractFactory {
    @Override
    public Computer makeComputer() {
        return new MiComputer();
    }

    @Override
    public MobilePhoto makeMobilePhoto() {
        return new MiPhoto();
    }
}