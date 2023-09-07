package cn.edu.lcu.cs.designpattern.factory.computer;

/**
 * @description:
 * @author: ling
 * @since: 2021-09-07 16:36
 **/
public class XpsFactory implements ComputerFactory {
    @Override
    public Computer build() {
        return new XPS();
    }
}
