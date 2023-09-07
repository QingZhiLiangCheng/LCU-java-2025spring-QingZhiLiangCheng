package cn.edu.lcu.cs.designpattern.bridge.fried_chicken;

/**
 * 炸鸡
 */
public class FriedChicken {
    private Sauce sauce;
    private FriedDish friedDish;
    private String rice;
    private String friedChicken;

    public FriedChicken(FriedDish friedDish, Sauce sauce) {
        this.friedDish = friedDish;
        this.sauce = sauce;
        rice = "大米饭";
        friedChicken = "炸鸡";
    }

    public Sauce getSauce() {
        return sauce;
    }

    public void setSauce(Sauce sauce) {
        this.sauce = sauce;
    }

    public FriedDish getFriedDish() {
        return friedDish;
    }

    public void setFriedDish(FriedDish friedDish) {
        this.friedDish = friedDish;
    }

    @Override
    public String toString() {
        return "脆皮炸鸡配料：\t" + friedChicken + "\t" + rice + "\t" + friedDish.getName() + "\t" + sauce.getName();
    }
}
