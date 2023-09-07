package cn.edu.lcu.cs.designpattern.factory.computer;

/**
 * @description: Vostro的工厂类，返回组装好的电脑。
 * @author: ling
 * @since: 2021-09-07 16:35
 **/
public class VostroFactory implements ComputerFactory {
    @Override
    public Computer build() {
        return new Vostro();
    }
}
