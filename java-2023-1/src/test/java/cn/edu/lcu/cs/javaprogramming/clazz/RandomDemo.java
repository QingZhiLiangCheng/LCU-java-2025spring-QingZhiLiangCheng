package cn.edu.lcu.cs.javaprogramming.clazz;

import cn.edu.lcu.cs.javaprogramming.BaseTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.Random;

/**
 * 随机对象演示
 * 
 * @author Ling
 *
 */
public class RandomDemo extends BaseTest {

	/**
	 * 生成10个随机数，重复运行5次，每次使用相同的种子。
	 */
	@RepeatedTest(5)
	public void randomWithFixSeed() {
		int seed = 0;
		// 代码填空


	}

	/**
	 * 生成10个随机数，重复运行5次，每次使用不同的种子。
	 */
	@RepeatedTest(5)
	public void randomWithChangingSeeds() {
		 //代码填空



	}

	/**
	 * 生成[low, high]之间的count个随机数，使用Junit5的参数化测试。
	 */
	@ParameterizedTest
	@CsvSource({"41, 0, 100", "43, 60, 100"})
	public void randomInts(int count, int low, int high) {
		//代码填空



	}

}
