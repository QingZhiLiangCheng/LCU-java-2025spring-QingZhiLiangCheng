package cn.edu.lcu.cs.javaprogramming.enumdemo;

/**
 * 颜色枚举类，表示基本颜色及其对应的中文名称。
 */
public enum Color {
    /**
     * 红色，代表基本颜色之一
     */
    RED("红"),

    /**
     * 绿色，代表基本颜色之一
     */
    GREEN("绿"),

    /**
     * 蓝色，代表基本颜色之一
     */
    BLUE("蓝");


    /**
     * 存储颜色的中文名称。
     */
    private String name;

    /**
     * 构造函数，初始化颜色的中文名称。
     *
     * @param name 颜色的中文名称
     */
    private Color(String name) {
        this.name = name;
    }

    /**
     * 重写 toString 方法，返回颜色的中文名称。
     *
     * @return 颜色的中文名称
     */
    @Override
    public String toString() {
        return name;
    }
}
