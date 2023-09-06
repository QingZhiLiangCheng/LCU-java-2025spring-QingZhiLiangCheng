package cn.edu.lcu.cs.design_pattern.bridge.pen;

//扩充实现类
public class Blue implements Color {
    public void bepaint(String penType, String name) {
        System.out.println(penType + "蓝色的" + name + ".");
    }
}
