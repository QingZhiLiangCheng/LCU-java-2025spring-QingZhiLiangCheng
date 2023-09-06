package cn.edu.lcu.cs.basic.relationship.inherit.animal;

import java.util.Date;

/**
 * 2020-04-04 22:47:57
 * <li>动物超类</li>
 * <li>没有具体的个体，不能实例化，是抽象类</li>
 * <li>定义了所有动物共有的属性与操作</li>
 * <li>共有属性：名称，物种名称，出生日期，性别，颜色，身高，体重，身长，体温类型等</li>
 * <li>共有操作：呼吸，进食，生殖，哺育后代等</li>
 * <li></li>
 * 
 * @author Ling
 *
 */
public abstract class Animal {
	private String name; // 名称
	private String specieName; // 物种名称
	private Date birthdate; // 出生日期
	private double height; // 身高
	private double length; // 体长
	private double weight; // 体重
	private String temperatureType; // 体温类型：冷血动物，温血动物

	/**
	 * 动物是抽象类，名称这个属性没有意义，所以这个构造方法不合适，应该在具体子类中添加包含名称的构造器
	 * 
//	 * @param name
	 */
//	public Animal(String name) {
//		super();
//		this.name = name;
//	}

	public Animal() {
	}

	@Override
	public String toString() {

		return "{名字：" + name + ", 物种：" + specieName + ", 出生日期：" + birthdate + ", 身高：" + height + ", 体重：" + weight + "}";
	}

	/**
	 * 进食
	 */
	public abstract void eat();

	/**
	 * 呼吸
	 */
	public abstract void breath();

	/**
	 * 哺育后代
	 * 并不是所有动物都养育后代，所以在动物基类中删除此方法
	 */
//	public abstract void feed();

	/**
	 * 生殖
	 */
	public abstract void reproduce();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public double getLength() {
		return length;
	}

	public void setLength(double length) {
		this.length = length;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public String getTemperatureType() {
		return temperatureType;
	}

	public void setTemperatureType(String temperatureType) {
		this.temperatureType = temperatureType;
	}

	public String getSpecieName() {
		return specieName;
	}

	public void setSpecieName(String specieName) {
		this.specieName = specieName;
	}

	public String getNameAndSpecie() {
		return name + "[" + specieName + "]";
	}

}
