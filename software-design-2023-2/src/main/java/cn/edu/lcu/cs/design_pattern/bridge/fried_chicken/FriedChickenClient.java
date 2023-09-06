package cn.edu.lcu.cs.design_pattern.bridge.fried_chicken;

public class FriedChickenClient {
    /**
     * <li>脆皮炸鸡配料：	炸鸡	大米饭	炖土豆	蕃茄酱</li>
     * <li>脆皮炸鸡配料：	炸鸡	大米饭	西红柿炒鸡蛋	沙拉酱</li>
     * <li>脆皮炸鸡配料：	炸鸡	大米饭	西红柿炒鸡蛋	蕃茄酱</li>
     *
     * @param args
     */
    public static void main(String[] args) {
        FriedChicken friedChicken = new FriedChicken(new PotatoStew(), new TomatoSauce());
        System.out.println(friedChicken);
        FriedChicken friedChicken2 = new FriedChicken(new TomatoOmelette(), new SaladSauce());
        System.out.println(friedChicken2);
        FriedChicken friedChicken3 = new FriedChicken(new TomatoOmelette(), new TomatoSauce());
        System.out.println(friedChicken3);
    }
}
