package cn.edu.lcu.cs.basic.relationship.inherit.animal;

/**
 * <h3>鸟类，动物类的子类</h3>
 * <li>鸟类都有两条腿，都会行走，所以实现了Walkable接口</li>
 * <li>鸟类不见得都会飞会游，所以不能实现Flyable与Swimmable接口</li>
 * <li></li>
 * <li></li>
 * @author Ling
 *
 */
public abstract class Bird extends Animal implements Walkable{
	public Bird() {
		super();
		setSpecieName("鸟类");
		setTemperatureType("温血动物");
	}

	public Bird(String name) {
		this();
		setName(name);
	}
	

	/**
	 * 鸟类都用肺呼吸
	 */
	@Override
	public void breath() {
		System.out.println(this.getNameAndSpecie() + "用肺呼吸。");
	}

	/**
	 * 鸟类都产卵繁殖后代
	 */
	@Override
	public void reproduce() {
		System.out.println(this.getNameAndSpecie() + "产卵繁殖。");
	}

	/**
	 * <li>鸟类都会走，所以在鸟类类中定义通用的行走代码</li>
	 * <li>如果哪个子类有特殊的行走方式，可以在子类中重写此方法</li>
	 */
	@Override
	public void walk() {
		System.out.println(getNameAndSpecie() + "双腿行走");
	}
}
