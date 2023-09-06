package cn.edu.lcu.cs.basic.relationship.inherit.animal;

/**
 * 天鹅，飞翔，游泳，行走
 * 
 * @author Ling
 *
 */
public class Swan extends Bird implements Swimmable, Flyable, Feedable {
	

	public Swan() {
		super();
		setSpecieName(getSpecieName() + "--天鹅");
	}

	public Swan(String name) {
		this();
		setName(name);
	}

	@Override
	public void fly() {
		System.out.println(getNameAndSpecie() + " 排队飞行，飞得很高");
	}

	@Override
	public void swim() {
		System.out.println(getNameAndSpecie() + " 游泳很溜");
	}
	
	@Override
	public void walk() {
		System.out.println(getNameAndSpecie() + " 大腹便便蹒跚而行");
	}

	@Override
	public void eat() {
		System.out.println(getNameAndSpecie() + " 不喜欢吃鱼喜欢吃水草");

	}

	@Override
	public void feed() {
		System.out.println(getNameAndSpecie() + " 父母共同养育后代");
	}
	
	

}
