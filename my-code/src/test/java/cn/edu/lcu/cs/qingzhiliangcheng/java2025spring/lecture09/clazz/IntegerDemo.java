package cn.edu.lcu.cs.qingzhiliangcheng.java2025spring.lecture09.clazz;

import org.junit.jupiter.api.Test;

public class IntegerDemo {

	void boxing() {
		Integer i = 3;
	}

	/**
	 * 整数 < - > 字符串
	 */
	@Test
	public void valueOf() {
		String hexString = "face";
		// 字符串解析为整数，指定进制
		Integer number;
		number = Integer.valueOf(hexString, 16);
		//number = Integer.parseInt(hexString, 16);
		System.out.println("hexString = " + hexString);
		System.out.println("Integer.valueOf(hexString, 16) = " + number);
		System.out.println("number = " + number);
		System.out.println("Integer.toHexString(number) = " + Integer.toHexString(number));
		System.out.println("Integer.toBinaryString(number) = " + Integer.toBinaryString(number));
		System.out.printf("%x\n", number);
		System.out.printf("%X\n", number);
	}

	/**
	 * 数值的符号处理。
	 * Java的基本整数类型都是带符号数。
	 */
	@Test
	void signed() {
		byte x = -1;
		byte y = 127;
		System.out.println("x = " + x);
		System.out.println("Byte.toUnsignedInt(x) = " + Byte.toUnsignedInt(x));

		System.out.println("y = " + y);
		System.out.println("Byte.toUnsignedInt(y) = " + Byte.toUnsignedInt(y));
	}
}
