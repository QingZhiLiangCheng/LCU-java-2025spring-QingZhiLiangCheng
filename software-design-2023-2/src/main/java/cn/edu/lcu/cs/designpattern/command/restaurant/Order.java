package cn.edu.lcu.cs.designpattern.command.restaurant;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description 菜品订单
 * @Author Ling
 * @Date 2021/10/20 9:19
 * @Version 1.0
 */
public class Order {
    /**
     * 餐桌号
     */
    private int diningTable;
    /**
     * 菜品列表
     */
    private List<Cuisine> cuisines = new ArrayList<>();

    public List<Cuisine> getCuisines() {
        return cuisines;
    }

    public void add(Cuisine cuisine) {
        cuisines.add(cuisine);
    }

    public void remove(Cuisine cuisine) {
        cuisines.remove(cuisine);
    }

    public int getDiningTable() {
        return diningTable;
    }

    public void setDiningTable(int diningTable) {
        this.diningTable = diningTable;
    }
}
