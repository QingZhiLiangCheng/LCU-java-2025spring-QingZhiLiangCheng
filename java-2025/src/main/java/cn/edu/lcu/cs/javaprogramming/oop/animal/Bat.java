package cn.edu.lcu.cs.javaprogramming.oop.animal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
public class Bat extends Mammal implements Flyable {
    // 蝙蝠特有的属性
    private boolean canFly; // 是否能飞行

    // 默认构造函数
    public Bat() {
        super(); // 调用父类的默认构造函数
        this.canFly = true; // 蝙蝠默认能飞行
        this.setSpecies("蝙蝠"); // 重写种类属性
    }

    // 方法：蝙蝠飞行
    @Override
    public void fly() {
        System.out.println(getName() + " is flying.");
    }

    // 重写父类的 eat 方法，添加蝙蝠特有的进食行为
    @Override
    public void eat(String food) {
        System.out.println(getName() + " is eating " + food + " while hanging upside down.");
    }

    // 重写父类的 breathe 方法，添加蝙蝠特有的呼吸行为
    @Override
    public void breathe() {
        System.out.println(getSpecies() + "用肺呼吸，并通过回声定位导航。");
    }
}
