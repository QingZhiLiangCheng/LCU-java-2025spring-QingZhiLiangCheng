package cn.edu.lcu.cs.design_pattern.bridge.pen;

//扩充实现类
public class Green implements Color {
    public void bepaint(String penType, String name) {
        System.out.println(penType + "绿色的" + name + ".");
    }
}
