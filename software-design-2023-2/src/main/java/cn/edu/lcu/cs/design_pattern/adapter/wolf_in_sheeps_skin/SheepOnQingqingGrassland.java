package cn.edu.lcu.cs.design_pattern.adapter.wolf_in_sheeps_skin;

/**
 * 青青草原上的羊
 *
 * @author ling
 * @date 2022/10/3 22:37
 */
public class SheepOnQingqingGrassland implements Sheep {
    private String name;

    public String getName() {
        return name;
    }

    public SheepOnQingqingGrassland(String name) {
        this.name = name;
    }

    @Override
    public void eatGrass() {
        System.out.println("我是" + name + ", 喜欢吃青草。");
    }

    @Override
    public void bleat() {
        System.out.println("我是" + name + ", 喜欢咩咩叫。");
    }
}
