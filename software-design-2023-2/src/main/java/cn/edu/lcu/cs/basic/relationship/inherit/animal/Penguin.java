package cn.edu.lcu.cs.basic.relationship.inherit.animal;

/**
 * 企鹅
 * 
 * @author Ling
 *
 */
public class Penguin extends Bird implements Swimmable, Feedable{

	public Penguin() {
		super();
		setSpecieName(super.getSpecieName() + "--企鹅");
	}

	public Penguin(String name) {
		this();
		setName(name);
	}

	@Override
	public void eat() {
		System.out.println(getNameAndSpecie() + "喜欢吃鱼");
	}

	@Override
	public void feed() {
		System.out.println(getNameAndSpecie() + "父母共同养育后代");
	}

	@Override
	public void walk() {
		System.out.println(getNameAndSpecie() + "摇摇摆摆蹒跚而行");
	}

	@Override
	public void swim() {
		System.out.println(getNameAndSpecie() + "游泳666");
	}

}
