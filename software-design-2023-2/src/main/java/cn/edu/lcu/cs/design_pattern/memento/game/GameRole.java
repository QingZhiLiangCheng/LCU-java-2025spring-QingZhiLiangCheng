package cn.edu.lcu.cs.design_pattern.memento.game;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GameRole {

    /**
     * 生命力，攻击力。
     */
    private int vitality;
    /**
     * 防御力
     */
    private int defence;

    /**
     * 创建Memento ,即根据当前的状态得到Memento
     *
     * @return
     */
    public Memento createMemento() {
        return new Memento(vitality, defence);
    }

    /**
     * 从备忘录对象，恢复GameRole的状态
     *
     * @param memento
     */
    public void recoverGameRoleFromMemento(Memento memento) {
        this.vitality = memento.getVitality();
        this.defence = memento.getDefence();
    }

    /**
     * 显示当前游戏角色的状态
     */
    public void display() {
        System.out.println("游戏角色当前的攻击力：" + this.vitality + " 防御力: " + this.defence);
    }
}
