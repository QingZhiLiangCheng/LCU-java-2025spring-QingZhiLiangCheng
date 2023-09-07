package cn.edu.lcu.cs.designpattern.memento.theory;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

/**
 * 管理人（守护者），保存一个或多个备忘录对象。
 *
 * @author ling
 * @date 2022/12/5 22:50
 */
@Getter
@Setter
public class Caretaker {
    /**
     * 保存的备忘录对象
     */
    //private Memento memento;


    /**
     * 保存的备忘录对象列表
     */
    private List<Memento> mementos = new ArrayList<Memento>();
}
