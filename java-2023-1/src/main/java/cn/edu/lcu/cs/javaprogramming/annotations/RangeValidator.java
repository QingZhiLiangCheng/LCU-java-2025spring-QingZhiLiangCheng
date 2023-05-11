package cn.edu.lcu.cs.javaprogramming.annotations;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.Arrays;

/**
 * 范围注解的检验器
 *
 * @author ling
 * @date 2022/5/7 21:48
 */
public class RangeValidator {
    /**
     * 验证目标对象的某些字段是否符合Range注解的标注范围。
     * 用传统的方法实现。
     *
     * @param target 验证目标（加了注解的对象）
     * @return 验证结果
     * @throws IllegalAccessException
     */
    @Deprecated
    public static boolean validate1(Object target) throws IllegalAccessException {
        boolean isValid = false;

        if (target != null) {
            // 获取所有声明的字段
            Field[] fields = target.getClass().getDeclaredFields();
            // 处理所有字段
            for (Field field : fields) {
                // 尝试获取字段上标注的@Range注解
                Range annotation = field.getAnnotation(Range.class);
                // 如果字段上做了@Range标注
                if (annotation != null) {
                    // 设置字段可访问
                    field.setAccessible(true);
                    // 获取字段上通过注解指定的最大最小值
                    long min = annotation.min();
                    long max = annotation.max();
                    // 获取字段的值
                    Object value = field.get(target);
                    // 判断被注解的字段是否是数值类型
                    if (value instanceof Number) {
                        int intValue = ((Number) value).intValue();
                        // 如果字段值在注解指定的范围之内，暂时设置结果为真，然后进行下个字段的验证。
                        if (intValue <= max && intValue >= min) {
                            isValid = true;
                        } else {
                            // 如果当前字段值不在注解指定的范围之内，验证失败，后续的字段也不需要验证了，退出循环。
                            isValid = false;
                            break;
                        }
                    } else {
                        // 如果字段上加了注解，但字段不是数值类型，验证失败，退出循环
                        isValid = false;
                        break;
                    }
                }
            }
        }

        return isValid;
    }

    /**
     * 验证目标对象的某些字段是否符合Range注解的标注范围。
     * 用stream的方法实现。
     *
     * @param target 验证目标（加了注解的对象）
     * @return 验证结果
     * @throws IllegalAccessException
     */
    public static boolean validate(Object target) {
        boolean isValid = false;

        if (target != null) {
            // 获取所有声明的字段
            Field[] fields = target.getClass().getDeclaredFields();
            isValid = Arrays.stream(fields)
                    // 过滤掉不带Range注解的字段
                    .filter(field -> field.isAnnotationPresent(Range.class))
                    // 是否所有字段都满足条件
                    .allMatch(field -> {
                        // 设置可访问性，即使私有字段也可以访问了。
                        field.setAccessible(true);
                        try {
                            // 获取字段的值对象
                            Object valueObject = field.get(target);
                            // 如果字段是数值类型
                            if (valueObject instanceof Number) {
                                // 获取数值字段的整数值
                                int intValue = ((Number) valueObject).intValue();
                                // 获取注解对象
                                Range annotation = field.getAnnotation(Range.class);
                                // 获取注解上标注的最大、最小值
                                int max = annotation.max();
                                int min = annotation.min();
                                // 如果字段值在注解指定范围之内，返回真
                                if (min <= intValue && intValue <= max) {
                                    return true;
                                }
                            }
                        } catch (IllegalAccessException e) {
                            throw new RuntimeException(e);
                        }
                        // 返回假，验证失败
                        // 1、虽然加了Range注解，但字段并不是数值类型
                        // 2、虽然加了Range注解而且是数值类型的字段，但是字段值不在指定范围之内
                        // 3、验证期间发生了某些异常
                        return false;
                    });
        }

        return isValid;
    }
}