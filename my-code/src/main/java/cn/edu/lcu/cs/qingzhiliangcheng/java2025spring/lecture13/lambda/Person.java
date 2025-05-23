package cn.edu.lcu.cs.qingzhiliangcheng.java2025spring.lecture13.lambda;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public class Person {
    @Getter
    private String firstName;
    @Getter
    private String lastName;
    @Getter
    private int age;
}