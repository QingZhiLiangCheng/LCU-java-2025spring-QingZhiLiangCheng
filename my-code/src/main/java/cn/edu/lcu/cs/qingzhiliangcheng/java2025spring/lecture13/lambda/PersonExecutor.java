package cn.edu.lcu.cs.qingzhiliangcheng.java2025spring.lecture13.lambda;

/**
 * PersonExecutor接口用于执行与Person对象相关的操作
 * 它定义了一个方法，允许用户将特定的操作应用于Person对象
 */
@FunctionalInterface
public interface PersonExecutor {
    /**
     * 执行与Person对象相关的操作
     *
     * @param person 要执行操作的Person对象，不能为空
     *               此参数代表了操作的目标，调用者需要提供一个Person实例
     *               以供execute方法执行其特定的逻辑
     */
    void execute(Person person);
}

