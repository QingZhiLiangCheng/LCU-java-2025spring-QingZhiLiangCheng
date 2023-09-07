package cn.edu.lcu.cs.designpattern.memento.game;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * 备忘录
 */
@Getter
@Setter
@AllArgsConstructor
public class Memento {

    /**
     * 攻击力
     */
    private int vitality;
    /**
     * 防御力
     */
    private int defence;

}
