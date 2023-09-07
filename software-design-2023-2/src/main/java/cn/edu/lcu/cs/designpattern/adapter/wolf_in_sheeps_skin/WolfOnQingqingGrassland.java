package cn.edu.lcu.cs.designpattern.adapter.wolf_in_sheeps_skin;

/**
 * 青青草原上的狼
 *
 * @author ling
 * @date 2022/10/3 22:47
 */
public class WolfOnQingqingGrassland implements Wolf {
    private String name;

    public String getName() {
        return name;
    }

    public WolfOnQingqingGrassland(String name) {
        this.name = name;
    }

    @Override
    public void eatMeat() {
        System.out.println("我是" + name + ", 喜欢吃羊肉。");
    }

    @Override
    public void howl() {
        System.out.println("我是" + name + ", 我一定会回来的。");
    }
}
