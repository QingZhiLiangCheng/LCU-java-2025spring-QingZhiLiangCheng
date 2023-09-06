package cn.edu.lcu.cs.design_pattern.composite.district2;


/**
 * @Author Ling
 * @Date 2021/9/16 22:04
 * @Version 1.0
 */
public class Client {
    public static void main(String[] args) {
        District districtTree = DistrictTreeBuilder.build();
        districtTree.traversal();
    }
}
