package cn.edu.lcu.cs.design_pattern.facade.theory;

/**
 * @Description 门面类，持有各子系统，为其提供统一的接口，不会把子系统的接口直接暴露给客户程序。
 * @Author Ling
 * @Date 2021/9/29 21:29
 * @Version 1.0
 */
public class Facade {
    private Sub1 sub1;
    private Sub2 sub2;
    private Sub3 sub3;

    /**
     * 集成操作，调用某些子系统的某些功能，完成复杂的操作。
     */
    public void integratedOperation1() {
        sub1.operation1();
        sub2.operation2();
    }

    /**
     * 集成操作，调用某些子系统的某些功能，完成复杂的操作。
     */
    public void integratedOperation2() {
        sub3.operation3();
        sub2.operation2();
    }
}
