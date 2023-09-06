package cn.edu.lcu.cs.design_pattern.composite.theory;

/**
 * 叶子构件
 * 2022/9/13 16:47
 *
 * @Author ling
 */
public class Leaf extends Component {
    @Override
    public void operation() {
        System.out.println("子构件");
    }
}
