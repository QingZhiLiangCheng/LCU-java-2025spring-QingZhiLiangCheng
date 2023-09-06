package cn.edu.lcu.cs.basic.relationship.inherit.animal;

/**
 * <li>鱼类是动物的子类</li>
 * <li>鱼类都会游泳，所以实现了Swimmable接口</li>
 * @author Ling
 *
 */
public abstract class Fish extends Animal implements Swimmable {
	

	public Fish() {
		super();
		setSpecieName("鱼类");
		setTemperatureType("冷血动物");
	}

	/**
	 * 不同鱼类，进食不同，所以在Fish里定义不合适
	 */
//	@Override
//	public void eat() {
//	}

	/**
	 * 所有鱼类都用腮呼吸，可以在Fish类里定义这个方法
	 */
	@Override
	public void breath() {
		System.out.println(getNameAndSpecie() + " 用腮呼吸");
	}

	/**
	 * 不同的鱼类，哺育后代的方式不同，所以不能在Fish类里定义这个方法
	 */
//	@Override
//	public void feed() {
//	}

	/**
	 * 不同的鱼类，繁殖后代的方式不同，所以不能在Fish类里定义这个方法
	 */
//	@Override
//	public void reproduce() {
//	}

}
