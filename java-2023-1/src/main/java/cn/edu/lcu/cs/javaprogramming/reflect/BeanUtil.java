package cn.edu.lcu.cs.javaprogramming.reflect;

import java.lang.reflect.Field;

public class BeanUtil {

    /**
     * 打印目标对象的所有字段值，无论公开的，还是私有的。
     *
     * @param target
     */
    public static void printFields(Object target) throws IllegalAccessException {
        if (target != null) {
            Class<?> targetClass = target.getClass();
            System.out.println("targetClass = " + targetClass);
            Field[] declaredFields = targetClass.getDeclaredFields();
            for (Field field : declaredFields) {
                field.setAccessible(true);
                String fieldName = field.getName();
                System.out.println(field + " = " + field.get(target));
            }
        }
    }
}
