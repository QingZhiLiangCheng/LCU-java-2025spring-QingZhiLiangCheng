package cn.edu.lcu.cs.design_pattern.builder.lombok;

import lombok.Builder;
import lombok.Data;
import lombok.NonNull;
import lombok.Singular;

import java.util.Date;
import java.util.Set;

/**
 * Lombok builder 演示
 */
@Data
@Builder(toBuilder = true)
public class Room {
    @NonNull
    private String id;
    private String name;
    private boolean active;
    private Date createTime;
    @Singular // 单数注释与@Builder一起使用以在构建器中为集合创建单个元素的“添加”方法。
    private Set<String> occupations;

}