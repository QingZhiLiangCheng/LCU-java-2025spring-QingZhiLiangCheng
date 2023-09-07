package cn.edu.lcu.cs.designpattern.bridge.pen;

//扩充实现类
public class White implements Color {
    public void bepaint(String penType, String name) {
        System.out.println(penType + "白色的" + name + ".");
    }
}
