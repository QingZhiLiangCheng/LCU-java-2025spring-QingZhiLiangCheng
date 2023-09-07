package cn.edu.lcu.cs.designpattern.abstract_factory.computer;

public class AppleFactory implements AbstractFactory {
    @Override
    public Computer makeComputer() {
        return new MacComputer();
    }

    @Override
    public MobilePhoto makeMobilePhoto() {
        return new IPhoto();
    }
}