package cn.edu.lcu.cs.design_pattern.composite.district;

import lombok.*;

/**
 * 行政级别
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = {"id", "parent"})
public abstract class District implements Iterable {
    private String id;
    private String name;
    private District parent;

    /**
     * 行政区级别，国家0，省级1，市级2，县级3
     */
    private DistrictLevel level;

    public abstract void traversal();

    /**
     * 行政级别
     */
    public enum DistrictLevel {
        NATIONAL, PROVINCIAL, MUNICIPAL, COUNTY
    }


}
