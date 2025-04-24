package cn.edu.lcu.cs.javaprogramming.clazz;

import cn.edu.lcu.cs.javaprogramming.BaseTest;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.security.SecureRandom;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/**
 * 随机对象演示
 *
 * @author Ling
 */
public class RandomDemo extends BaseTest {

    /**
     * 计算机语言中的随机数对象，不是真正的随机数，是伪随机数。
     * 生成10个随机数，重复运行5次，每次使用相同的种子。
     * 用相同种子生成的随机数对象，生成的随机数序列是固定的。
     */
    @RepeatedTest(5)
    public void randomWithFixSeed() {
        int seed = 0;
        //代码填空
        Random random = new Random(seed);
        System.out.println(random.nextInt());
        System.out.println(random.nextInt(100));
    }

    /**
     * 生成10个随机数，重复运行5次，每次使用不同的种子。
     */
    @RepeatedTest(5)
    public void randomWithChangingSeeds() {
        //代码填空
        Random random = new Random();
        System.out.println(random.nextInt());
        System.out.println(random.nextInt(100));
    }


    /**
     * 生成[low, high]之间的count个随机数，使用Junit5的参数化测试。
     */
    @ParameterizedTest
    @CsvSource({"41, 0, 100", "43, 60, 100"})
    public void randomInts(int count, int low, int high) {
        Random random = new Random();
        //代码填空
        for (int i = 0; i < count; i++) {
            // [0, high-low]
            int r = random.nextInt(high - low + 1);
            // [low, high]
            r += low;
            System.out.print("\t" + r);
        }
        System.out.println();
    }

    /**
     * 生成[low, high]之间的count个随机数，使用Junit5的参数化测试。
     */
    @ParameterizedTest
    @CsvSource({"41, 0, 100", "43, 60, 100"})
    public void randomInts2(int count, int low, int high) {
        Random random = new Random();
        random.ints(count, low, high)
//				.forEach(System.out::println);
                .forEach(r -> System.out.print("\t" + r));
        System.out.println();
    }

    /**
     * 生成[0,100)的整数
     */
    @Test
    public void randomInt() {
        // Random 生成 [0, 100) 整数
        Random random = new Random();
        int num = random.nextInt(100);

        // SecureRandom 生成 16 字节随机数据
        SecureRandom secureRandom = new SecureRandom();
        byte[] bytes = new byte[16];
        secureRandom.nextBytes(bytes);

        // ThreadLocalRandom 生成 [1, 100] 整数
        int threadNum = ThreadLocalRandom.current().nextInt(1, 101);
    }
}
