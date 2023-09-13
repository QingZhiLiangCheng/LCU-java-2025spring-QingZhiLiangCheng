package cn.edu.lcu.cs.designpattern.simple_factory.computer_factory.factory;

public class XPSFactory extends ComputerFactory {
    @Override
    public Computer build() {
        return new XPS();
    }
}
