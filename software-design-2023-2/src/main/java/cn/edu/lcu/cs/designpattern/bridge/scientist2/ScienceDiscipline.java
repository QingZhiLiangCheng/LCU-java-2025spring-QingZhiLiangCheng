package cn.edu.lcu.cs.designpattern.bridge.scientist2;

import lombok.Data;

/**
 * @description: 科学学科
 * @author: ling
 * @since: 2021-09-28 15:50
 **/
@Data
public abstract class ScienceDiscipline {
    private Scientist scientist;
    private String disciplineName;

    public void print() {
        System.out.println(scientist.getGender() + disciplineName + "家");
    }

}
