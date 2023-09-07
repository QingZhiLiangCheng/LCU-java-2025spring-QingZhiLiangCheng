package cn.edu.lcu.cs.designpattern.adapter.wolf_in_sheeps_skin;

/**
 * 披着羊皮的狼，这是一个适配器类。
 *
 * @author ling
 * @date 2022/10/3 22:32
 */
public class WolfInSheepsSkin implements Sheep {
    private Wolf wolf;

    public WolfInSheepsSkin(Wolf wolf) {
        this.wolf = wolf;
    }

    @Override
    public void eatGrass() {
        System.out.println("我是一只狼，假装在吃草");
        wolf.eatMeat();
    }

    @Override
    public void bleat() {
        System.out.println("我是一只狼，假装在咩咩叫。");
        wolf.howl();
    }
}
