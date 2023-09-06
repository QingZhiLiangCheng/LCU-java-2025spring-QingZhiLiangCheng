package cn.edu.lcu.cs.design_pattern.bridge.fried_chicken;

/**
 * 酱，一系列类与子类
 */
public abstract class Sauce {
    private String name;
    private String taste;

    public Sauce(String name, String taste) {
        this.name = name;
        this.taste = taste;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTaste() {
        return taste;
    }

    public void setTaste(String taste) {
        this.taste = taste;
    }
}
