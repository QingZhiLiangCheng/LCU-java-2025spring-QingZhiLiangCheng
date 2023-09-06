package cn.edu.lcu.cs.design_pattern.iterator.iterable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Person {
    private Integer id;
    private String name;
    private String gender;
    private LocalDate birthdate;
    private Integer height; // 身高，厘米
    private Integer weight; // 体重，市斤

    public Person(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getAge() {
        if (birthdate == null) {
            return null;
        } else {
            return (int) birthdate.until(LocalDate.now(), ChronoUnit.YEARS);
        }
    }
}
