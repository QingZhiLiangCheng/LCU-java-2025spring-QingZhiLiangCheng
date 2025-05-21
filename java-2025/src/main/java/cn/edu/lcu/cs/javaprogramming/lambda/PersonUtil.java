package cn.edu.lcu.cs.javaprogramming.lambda;

import java.util.List;

public class PersonUtil {
    public static void checkAndExecute(List<Person> persons, PersonChecker checker, PersonExecutor executor) {
        for (Person person : persons) {
            if (checker.check(person)) {
                executor.execute(person);
            }
        }
    }
}
