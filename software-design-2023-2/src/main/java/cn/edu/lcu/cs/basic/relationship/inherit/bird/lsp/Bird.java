package cn.edu.lcu.cs.basic.relationship.inherit.bird.lsp;

//@Data
public abstract class Bird {
//    private String species;
//    private String name;
//    private LocalDate birthdate;
//    private String color;
//
//    public long getAge() {
//        if (birthdate != null) {
//            return birthdate.until(LocalDate.now(), ChronoUnit.YEARS);
//        } else {
//            return -1;
//        }
//    }

    public void breath() {
        System.out.println("鸟类都是用肺呼吸");
    }

    public void reproduce() {
        System.out.println("鸟类都是产卵繁殖");
    }

    /**
     * 不是所有鸟类都会飞，所以在抽象基类中不应该定义该方法，应该抽取到一个接口中。
     */
//    public abstract void fly();

    /**
     * 所有鸟类都有吃的行为，但是饮食有区别，在基类中定义抽象方法。
     */
    public abstract void eat();

    /**
     * 所有鸟类都会走路，但是走路方式有区别，在基类中定义抽象方法。
     */
    public abstract void walk();

}
