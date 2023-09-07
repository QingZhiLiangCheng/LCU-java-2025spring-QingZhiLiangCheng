package cn.edu.lcu.cs.designpattern.adapter.wolf_in_sheeps_skin;

/**
 * @author ling
 * @date 2022/10/3 22:49
 */
public class Client {
    public static void main(String[] args) {
        Wolf huitailang = new WolfOnQingqingGrassland("灰太狼");
        huitailang.eatMeat();
        huitailang.howl();

        Sheep xiyangyang = new SheepOnQingqingGrassland("喜羊羊");

        Sheep wolfInSheepsSkin = new WolfInSheepsSkin(huitailang);
        wolfInSheepsSkin.eatGrass();
        wolfInSheepsSkin.bleat();
    }
}
