package cn.edu.lcu.cs.javaprogramming.oop.animal;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Monkey {
    // 名称，种类名称，出生日期，颜色，体重，性别，体温类型（冷血、温血）
    private String name;
    private String species;
    private Date birthday;
    private String color;
    private double weight;
    private String gender;
    private String temperature;

}
