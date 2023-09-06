package cn.edu.lcu.cs.design_pattern.adapter.object;

/**
 * <h3>对象适配器类。</h3>
 * <p>通过持有（组合、聚合）适配者对象进行适配。</p>
 * <h4>注入所依赖的适配者对象的方法：</h4>
 * <ol>
 *     <li>通过setter，由客户程序注入</li>
 *     <li>通过带参的构造方法注入</li>
 *     <li>直接创建固定的适配者对象，不需要客户程序注入</li>
 * </ol>
 */
public class Adapter implements Target {
    /**
     * 聚合既有适配者类，而不是继承，优点总比缺点多。
     */
    private Adaptee1 adaptee1;
    private Adaptee2 adaptee2;


    public void setAdaptee1(Adaptee1 adaptee1) {
        this.adaptee1 = adaptee1;
    }

    public void setAdaptee2(Adaptee2 adaptee2) {
        this.adaptee2 = adaptee2;
    }

    /**
     * 默认构造方法中，直接注入依赖的适配者对象。
     * 客户程序不用考虑底层的细节，仅仅关心适配器就可以了。
     * 但也牺牲了灵活性。
     */
    public Adapter() {
        adaptee1 = new Adaptee1();
        adaptee2 = new Adaptee2();
    }

    /**
     * 在构造适配器对象时，注入依赖的适配者对象。
     * 需要客户程序了解适配器的底层细节，起码需要知晓它依赖哪些对象，增加了客户程序的负担。
     *
     * @param adaptee1
     * @param adaptee2
     */
    public Adapter(Adaptee1 adaptee1, Adaptee2 adaptee2) {
        this.adaptee1 = adaptee1;
        this.adaptee2 = adaptee2;
    }

    /**
     * 将适配者1中的方法转换为适配器的方法
     */
    @Override
    public void operation1() {
        adaptee1.operation1();
    }

    /**
     * 将适配者2中的方法转换为适配器的方法
     */
    @Override
    public void operation2() {
        adaptee2.operation2();
    }

    /**
     * 没有现成的轮子，只好亲自实现。
     */
    @Override
    public void operation3() {
        System.out.println("Method in adapter.");
    }
}
