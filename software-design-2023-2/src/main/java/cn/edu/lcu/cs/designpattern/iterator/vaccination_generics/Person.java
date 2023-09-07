package cn.edu.lcu.cs.designpattern.iterator.vaccination_generics;

import lombok.Getter;
import lombok.Setter;

/**
 * @Description 接种人
 * @Author Ling
 * @Date 2021/9/29 23:50
 * @Version 1.0
 */
@Getter @Setter
public class Person {
    /**
     * 是否已经接种过疫苗
     */
    private boolean vaccinated;

    /**
     * 身份证号
     */
    private String idcard;

    public Person(String name) {
        this.name = name;
    }

    public Person() {
    }

    private String name;
}
