package cn.edu.lcu.cs.design_pattern.visitor.family;

/**
 * @Description 家庭访问示例客户端
 * @Author Ling
 * @Date 2021/10/6 12:58
 * @Version 1.0
 */
public class Client {
    public static void main(String[] args) {
        Family family = new Family();
        family.addFolk(new Father());
        family.addFolk(new Mother());
        family.addFolk(new Brother());
        family.addFolk(new Sister());

        Visitor visitor = new TeacherVisitor();
        System.out.println("教师家访来了");
        // 将家庭作为整体进行访问
//        visitor.visit(family);
        // 家庭接受教师的访问
        family.accept(visitor);

        System.out.println("--------------华丽丽的分隔线---------------------");

        System.out.println("爷爷奶奶来家里串门了");
        // 家庭接受祖父母的访问
        family.accept(new GrandParentVisitor());

    }
}
