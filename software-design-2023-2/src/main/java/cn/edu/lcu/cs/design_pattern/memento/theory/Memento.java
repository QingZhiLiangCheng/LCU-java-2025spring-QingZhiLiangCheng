package cn.edu.lcu.cs.design_pattern.memento.theory;

import lombok.Getter;
import lombok.Setter;

/**
 * 备忘录，负责保存发起人的内部状态。
 *
 * @author ling
 * @date 2022/12/5 22:50
 */
@Getter
@Setter
public class Memento {
    private String state;
}
