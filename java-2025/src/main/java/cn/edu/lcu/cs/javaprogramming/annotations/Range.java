package cn.edu.lcu.cs.javaprogramming.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 用于限制整型字段范围的注解
 *
 * @author ling
 * @date 2022/5/7 21:42
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface Range {
    int min() default 0;

    int max() default 100;
}