package cn.edu.lcu.cs.basic.relationship.inherit.animal;

/**
 * 鲨鱼
 * 
 * @author Ling
 *
 */
public class Shark extends Fish {
	public Shark() {
		super();
		setSpecieName(super.getSpecieName() + "--鲨鱼");
	}

	public Shark(String name) {
		this(); // 调用默认的无参构造器
		setName(name);
	}

	@Override
	public void swim() {
		System.out.println(getNameAndSpecie() + " 是游泳健将");
	}

	@Override
	public void eat() {
		System.out.println(getNameAndSpecie() + " 喜欢吃肉");
	}

	@Override
	public void reproduce() {
		System.out.println(getNameAndSpecie() + " 卵生或卵胎生");
	}

	/**
	 * 所有鱼类都用腮呼吸，这个方法已经在父类Fish中定义了，子类中不必再定义
	 */
//	@Override
//	public void breath() {
//		System.out.println(getName() + "用腮呼吸");
//	}

}
