package cn.edu.lcu.cs.design_pattern.visitor.family;

/**
 * @Description 教师访问者，教师家访
 * @Author Ling
 * @Date 2021/10/6 13:34
 * @Version 1.0
 */
public class TeacherVisitor implements Visitor {
    @Override
    public void visit(Mother mother) {
        System.out.println("妈妈多关心一下孩子的身心健康，不要整天盯着成绩不放。");
    }

    @Override
    public void visit(Father father) {
        System.out.println("爸爸别整天忙应酬，多花点时间陪陪孩子。");
    }

    @Override
    public void visit(Brother brother) {
        System.out.println("哥哥把暑假作业补齐了，明天交给我。");
    }

    @Override
    public void visit(Sister sister) {
        System.out.println("妹妹是个好学生，争取下次考年级第一。");
    }
}
