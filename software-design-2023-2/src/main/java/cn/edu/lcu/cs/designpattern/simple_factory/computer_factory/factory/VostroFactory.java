package cn.edu.lcu.cs.designpattern.simple_factory.computer_factory.factory;

public class VostroFactory extends ComputerFactory {
    @Override
    public Computer build() {
        return new Vostro();
    }
}
