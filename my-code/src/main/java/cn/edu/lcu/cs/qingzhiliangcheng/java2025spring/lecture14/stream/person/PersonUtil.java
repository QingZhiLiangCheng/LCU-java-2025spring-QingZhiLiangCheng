package cn.edu.lcu.cs.qingzhiliangcheng.java2025spring.lecture14.stream.person;

import cn.edu.lcu.cs.javaprogramming.stream.person.Person;

import java.util.ArrayList;
import java.util.List;

public class PersonUtil {

    public static List<Person> mockList() {
        List<Person> personList = new ArrayList<Person>();
        personList.add(new Person("Tom", 8900, 23, "male", "New York"));
        personList.add(new Person("Jack", 7000, 25, "male", "Washington"));
        personList.add(new Person("Lily", 7800, 21, "female", "Washington"));
        personList.add(new Person("Anni", 8200, 24, "female", "New York"));
        personList.add(new Person("Owen", 9500, 25, "male", "New York"));
        personList.add(new Person("Alisa", 7900, 26, "female", "New York"));
        return personList;
    }
}
