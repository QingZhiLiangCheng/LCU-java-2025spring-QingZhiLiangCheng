package cn.edu.lcu.cs.design_pattern.bridge.scientist;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @description: 科学家类
 * @author: ling
 * @since: 2021-09-28 15:46
 **/
@AllArgsConstructor
@NoArgsConstructor
@Data
public abstract class Scientist {
    private ScienceDiscipline scienceDiscipline;

    public abstract void print();
}
