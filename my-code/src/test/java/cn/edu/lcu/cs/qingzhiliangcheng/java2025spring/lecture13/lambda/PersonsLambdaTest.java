package cn.edu.lcu.cs.qingzhiliangcheng.java2025spring.lecture13.lambda;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

class PersonsLambdaTest {
    List<Person> guiltyPersons = Arrays.asList(
            new Person("Yixing", "Zhao", 25),
            new Person("Yanggui", "Li", 30),
            new Person("Chao", "Ma", 29));

    @Test
    void checkAndExecute() {
        PersonUtil.checkAndExecute(guiltyPersons, p -> p.getLastName().startsWith("Z"), p -> System.out.println(p.getFirstName()));
    }
}