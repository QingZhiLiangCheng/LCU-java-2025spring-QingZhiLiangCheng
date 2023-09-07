package cn.edu.lcu.cs.designpattern.builder.computer_factory;

/**
 * @description:
 * @author: ling
 * @since: 2021-09-07 16:36
 **/
public class XpsFactory implements ComputerFactory {
    /**
     * 工厂不负责组装电脑
     *
     * @return
     */
    @Override
    public Computer build() {
        return new XPS();
    }
}
