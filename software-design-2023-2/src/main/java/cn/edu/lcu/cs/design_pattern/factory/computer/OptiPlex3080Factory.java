package cn.edu.lcu.cs.design_pattern.factory.computer;

/**
 * @description:
 * @author: ling
 * @since: 2021-09-07 16:37
 **/
public class OptiPlex3080Factory implements ComputerFactory {
    @Override
    public Computer build() {
        return new OptiPlex3080();
    }
}
