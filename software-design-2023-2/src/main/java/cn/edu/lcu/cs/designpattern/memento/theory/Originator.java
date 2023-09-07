package cn.edu.lcu.cs.designpattern.memento.theory;

/**
 * 发起人，需要保存状态的对象。
 *
 * @author ling
 * @date 2022/12/5 22:50
 */
public class Originator {
    private String  state;

    public Memento createMemento() {
        return new Memento();
    }

    public void setMenento(Memento menento) {
        state = menento.getState();
    }

}
