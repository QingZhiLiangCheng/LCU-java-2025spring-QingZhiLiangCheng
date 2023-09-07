package cn.edu.lcu.cs.designpattern.facade.smart_house;

/**
 * @Description 智能家居客户端
 * @Author Ling
 * @Date 2021/9/21 22:32
 * @Version 1.0
 */
public class Client {
    public static void main(String[] args) {
        SmartHouseFacade smartHouseFacade = new SmartHouseFacade();
        // 回家：开电视，开空调，开灯，……
        smartHouseFacade.goHome();
        // 出门：关电视，关空调，关灯，……
        smartHouseFacade.goOutside();
    }
}
