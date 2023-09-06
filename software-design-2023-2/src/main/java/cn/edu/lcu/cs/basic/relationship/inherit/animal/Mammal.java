package cn.edu.lcu.cs.basic.relationship.inherit.animal;

/**
 * 哺乳动物类
 * 
 * @author Ling
 *
 */
public abstract class Mammal extends Animal {

	/**
	 * 不同的哺乳动物，进食方式不同，在此处不应该定义这个方法，应该在子类中定义
	 */
//	@Override
//	public void eat() {
//	}

	@Override
	public void breath() {
		System.out.println(getNameAndSpecie() + " 用肺呼吸");
	}

	@Override
	public void reproduce() {
	}

	public Mammal() {
		super();
		setSpecieName("哺乳动物");
		setTemperatureType("温血动物");
	}
	
}
