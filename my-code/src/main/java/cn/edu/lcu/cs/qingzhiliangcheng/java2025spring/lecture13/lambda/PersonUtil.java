package cn.edu.lcu.cs.qingzhiliangcheng.java2025spring.lecture13.lambda;


import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class PersonUtil {
    /**
     * 根据条件检查人员列表，并对符合条件的人员执行特定操作
     * 此方法实现了命令模式，将检查和执行逻辑解耦，使得代码更加灵活和可扩展
     *
     * @param persons  人员列表，待检查和执行操作的人员集合
     * @param checker  人员检查器，用于检查人员是否符合条件的接口
     * @param executor 人员执行器，用于对符合条件的人员执行操作的接口
     */
    public static void checkAndExecute(List<Person> persons, PersonChecker checker, PersonExecutor executor) {
        // 遍历人员列表
        for (Person person : persons) {
            // 使用PersonChecker接口的实现来检查人员是否符合条件
            if (checker.check(person)) {
                // 如果人员符合条件，则使用PersonExecutor接口的实现来执行特定操作
                executor.execute(person);
            }
        }
    }

    /**
     * 根据条件检查并执行相应操作
     * 该方法用于判断给定的人员是否满足特定条件，如果满足，则执行指定的操作
     *
     * @param person    要检查和操作的人员对象
     * @param condition 一个谓词，用于测试给定的人员是否满足条件
     * @param action    一个消费者，定义了当人员满足条件时要执行的操作
     * @return 如果人员满足条件并执行了操作，则返回true；否则返回false
     */
    public static boolean checkAndExecute(Person person, Predicate<Person> condition, Consumer<Person> action) {
        // 遍历人员列表
        if (condition.test(person)) {
            action.accept(person);
            return true;
        } else {
            return false;
        }
    }

}
