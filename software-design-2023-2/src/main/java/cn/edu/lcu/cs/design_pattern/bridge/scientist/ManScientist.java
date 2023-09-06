package cn.edu.lcu.cs.design_pattern.bridge.scientist;

/**
 * @description:
 * @author: ling
 * @since: 2021-09-28 15:47
 **/
public class ManScientist extends Scientist {
    @Override
    public void print() {
        System.out.println("男性" + getScienceDiscipline().getDisciplineName() + "家");
    }
}
